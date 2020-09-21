package com.ddnshop.rolesservice.controller;

import com.ddnshop.rolesservice.dto.UserRolesDTO;
import com.ddnshop.rolesservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/roles/{user_Id}")
    public ResponseEntity<UserRolesDTO> getRoles(@PathVariable("user_Id") int user_Id) {
        return new ResponseEntity<>(roleService.getRolesByUserId(user_Id),HttpStatus.OK);
    }
}
