package com.ddnshop.usersinfoservice.dao;

import com.ddnshop.usersinfoservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
