package com.example.MediCure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MediCure.payloads.DoctorDTO;
import com.example.MediCure.serviceimpl.DoctorImplemention;

@RestController
@RequestMapping("/api")
public class DoctorController {
	
	@Autowired
	DoctorImplemention service;

	@PostMapping("/doctor/{id}")
	ResponseEntity<DoctorDTO> insertDoctor(@RequestBody DoctorDTO doctordto,@PathVariable Integer id) {
		DoctorDTO dto=   service.insertDoctor(doctordto, id);
		return new ResponseEntity<DoctorDTO>(dto,HttpStatus.ACCEPTED);
	}
}
