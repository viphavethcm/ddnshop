package com.ddnshop.usersinfoservice.models;

import java.util.List;

public class UserRoles {
    private List<Role> roles;

    public UserRoles(List<Role> roles) {
        this.roles = roles;
    }
    public UserRoles(){}
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
