package com.example.MediCure.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MediCure.payloads.PatientDTO;
<<<<<<< HEAD
import com.example.MediCure.payloads.ResponseMsg;
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
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
<<<<<<< HEAD
	@GetMapping("/get-all-patients")
	public ResponseEntity<List<PatientDTO>> getAllPatients(){
		List<PatientDTO> list=service.getAllPatient();
		return new ResponseEntity<List<PatientDTO>>(list,HttpStatus.ACCEPTED);
	}
	@GetMapping("/get-patients/{id}")
	public ResponseEntity<PatientDTO> getPatientById(@PathVariable Integer id){
		PatientDTO list=service.getPatientById(id);
		return new ResponseEntity<PatientDTO>(list,HttpStatus.ACCEPTED);
	}
	@PutMapping("/update-patient/{id}")
	public ResponseEntity<PatientDTO> updatePatient(@PathVariable Integer id,@RequestBody PatientDTO dto){
		PatientDTO patient=service.updatePatient(id, dto);
		return new ResponseEntity<PatientDTO>(patient,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete-patient/{id}")
	public ResponseEntity<ResponseMsg> deletePatient(@PathVariable Integer id){
		Boolean patient=service.deletePatient(id);
		if(patient==true) {
			return new ResponseEntity<ResponseMsg>(new ResponseMsg("patient is deleted", patient),HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<ResponseMsg>(new ResponseMsg("patient is not deleted", patient),HttpStatus.BAD_REQUEST);
		}
	}
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
}
