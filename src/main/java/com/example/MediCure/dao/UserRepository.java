package com.example.MediCure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MediCure.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
