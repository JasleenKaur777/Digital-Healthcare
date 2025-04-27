package com.example.MediCure.service;

import java.util.List;

import com.example.MediCure.payloads.LoginDTO;
import com.example.MediCure.payloads.UserDTO;

public interface UserService {
UserDTO createUser(UserDTO userdto);
List<UserDTO> viewAll();
UserDTO updateUser(UserDTO userdto,Integer id);
Boolean deleteUser(Integer id);
UserDTO getUser(Integer id);
LoginDTO loginUser(LoginDTO dto);
List<UserDTO> getUserByRole(String role);
}
