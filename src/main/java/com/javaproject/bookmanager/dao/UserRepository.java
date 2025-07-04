package com.javaproject.bookmanager.dao;

import com.javaproject.bookmanager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findUserIdByUsername( String username);
}
