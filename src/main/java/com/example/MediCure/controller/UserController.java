package com.example.MediCure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MediCure.entity.User;
import com.example.MediCure.model.LoginUser;
import com.example.MediCure.payloads.ResponseMsg;
import com.example.MediCure.payloads.UserDTO;
import com.example.MediCure.service.UserService;
import com.example.MediCure.serviceimpl.UserImplemention;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserImplemention service;
	
	@PostMapping("/create-user")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto) {
	 UserDTO dto=	service.createUser(userdto);
	 return new ResponseEntity<UserDTO>(dto,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> viewAll(){
		List<UserDTO> dto=service.viewAll();
		return ResponseEntity.ok(dto);
	} 
	
	@PutMapping("/update-user/{id}")
	public ResponseEntity<ResponseMsg> updateUser(@RequestBody UserDTO userdto,@PathVariable Integer id) {
		UserDTO dto= service.updateUser(userdto, id);
		if(dto!=null) {
			return new ResponseEntity<ResponseMsg>(new ResponseMsg("Updation successfull", true),HttpStatus.ACCEPTED );	
		}
		else {
			return new ResponseEntity<ResponseMsg>(new ResponseMsg("Updation is not successfull", false),HttpStatus.NOT_FOUND );	
		}
				
	}
	
	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<ResponseMsg> deleteUser(@PathVariable Integer id) {
		Boolean b=service.deleteUser(id);
		if(b==true) {
			return new ResponseEntity<ResponseMsg>(new ResponseMsg("deletion successfull", true),HttpStatus.ACCEPTED );	
		}
		else {
			return new ResponseEntity<ResponseMsg>(new ResponseMsg("Deletion is not successfull", false),HttpStatus.NOT_FOUND );	
		}
	}
	
	@GetMapping("/get-user/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
		 UserDTO dto=	service.getUser(id);
		 return new ResponseEntity<UserDTO>(dto,HttpStatus.ACCEPTED);
	}

}
