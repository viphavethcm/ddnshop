package com.ddnshop.rolesservice.dao;

import com.ddnshop.rolesservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query("select role from Role role join fetch role.users users where users.user_Id = :user_Id")
    List<Role>findRoles(@Param("user_Id") int user_Id);
}
