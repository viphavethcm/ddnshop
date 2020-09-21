package com.ddnshop.rolesservice.dto;

import com.ddnshop.rolesservice.models.Role;

import java.util.List;

public class UserRolesDTO {

    private List<Role> roles;

    public UserRolesDTO(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
