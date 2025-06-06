package com.example.MediCure.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MediCure.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
User findByUsername(String username);
List<User> findByRole(String role);
}
