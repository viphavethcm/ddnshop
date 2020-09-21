package com.ddnshop.rolesservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@JsonIgnoreProperties(value = "users")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_Id;

    @Column(name = "rolename")
    private String rolename;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "role_Id")
    private List<UserRoles> users;

    public Role(){}

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

    public List<UserRoles> getUsers() {
        return users;
    }

    public void setUsers(List<UserRoles> users) {
        this.users = users;
    }
}
