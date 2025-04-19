package com.example.MediCure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MediCure.payloads.PatientDTO;
import com.example.MediCure.serviceimpl.PatientImplemention;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired
	PatientImplemention service;
	
	@PostMapping("/create-patient/userid/{userid}")
	public ResponseEntity<PatientDTO> createPatient(@PathVariable Integer userid,@RequestBody PatientDTO dto) {
		PatientDTO patientdto=   service.createPatient(userid, dto);
		return new ResponseEntity<PatientDTO>(patientdto,HttpStatus.ACCEPTED);
	}
}
