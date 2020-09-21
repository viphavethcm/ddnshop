package com.ddnshop.rolesservice.services;

import com.ddnshop.rolesservice.dao.RoleRepository;
import com.ddnshop.rolesservice.dto.UserRolesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public UserRolesDTO getRolesByUserId(Integer user_Id){
        return new UserRolesDTO(roleRepository.findRoles(user_Id));
    }

}
