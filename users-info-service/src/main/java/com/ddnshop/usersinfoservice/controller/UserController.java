package com.ddnshop.usersinfoservice.controller;

import com.ddnshop.usersinfoservice.models.User;
import com.ddnshop.usersinfoservice.repository.UserRepository;
import com.ddnshop.usersinfoservice.security.CurrentUser;
import com.ddnshop.usersinfoservice.security.ResourceNotFoundException;
import com.ddnshop.usersinfoservice.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    public ResponseEntity<User> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return ResponseEntity.ok()
                .body(userRepository.findById(userPrincipal.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId())));

    }
}
