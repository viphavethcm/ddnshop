package com.ddnshop.usersinfoservice.models;


import java.io.Serializable;

public class Role implements Serializable {
    private int role_Id;
    private String rolename;

    public Role(){}

    public Role(int role_Id, String rolename) {
        this.role_Id = role_Id;
        this.rolename = rolename;
    }

    public int getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(int role_Id) {
        this.role_Id = role_Id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
