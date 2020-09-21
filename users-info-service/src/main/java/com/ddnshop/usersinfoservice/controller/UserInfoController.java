package com.ddnshop.usersinfoservice.controller;

import com.ddnshop.usersinfoservice.dto.UserDTOs;
import com.ddnshop.usersinfoservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserInfoController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public UserDTOs getUsers(){
        return userService.findAll();
    }
}
