package com.ddnshop.usersinfoservice.dto;

import java.util.List;

public class UserDTOs {
    private List<UserDTO> users;

    public UserDTOs(List<UserDTO> users) {
        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
