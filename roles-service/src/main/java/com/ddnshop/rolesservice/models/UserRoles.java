package com.ddnshop.rolesservice.models;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "user_Id")
    private int user_Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }
}
