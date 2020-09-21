package com.ddnshop.usersinfoservice.dto;
import com.ddnshop.usersinfoservice.models.Role;

import java.util.List;

public class UserDTO {
    private int user_Id;
    private String username;
    private String password;
    private boolean active;
    private String created_Date;
    private String lastModified_Date;
    private List<Role> roles;

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCreated_Date() {
        return created_Date;
    }

    public void setCreated_Date(String created_Date) {
        this.created_Date = created_Date;
    }

    public String getLastModified_Date() {
        return lastModified_Date;
    }

    public void setLastModified_Date(String lastModified_Date) {
        this.lastModified_Date = lastModified_Date;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
