package com.example.MediCure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MediCure.payloads.DoctorDTO;
import com.example.MediCure.payloads.ResponseMsg;
import com.example.MediCure.serviceimpl.DoctorImplemention;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	DoctorImplemention service;

	@PostMapping("/{id}")
	ResponseEntity<DoctorDTO> insertDoctor(@RequestBody DoctorDTO doctordto,@PathVariable Integer id) {
		DoctorDTO dto=   service.insertDoctor(doctordto, id);
		return new ResponseEntity<DoctorDTO>(dto,HttpStatus.ACCEPTED);
	}
	@GetMapping("/")
	public ResponseEntity<List<DoctorDTO>> viewAllDoctor(){
		List<DoctorDTO> doctordtos=  service.viewAllDoctor();
		return new ResponseEntity<List<DoctorDTO>>(doctordtos,HttpStatus.ACCEPTED);
	}
	@GetMapping("/get-doctor/{id}")
	ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Integer id) {
		DoctorDTO dto=   service.getDoctorById(id);
		return new ResponseEntity<DoctorDTO>(dto,HttpStatus.ACCEPTED);
	}
	@PutMapping("/update-doctor/{id}")
	public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Integer id,@RequestBody DoctorDTO dto){
		DoctorDTO updatedto= service.updateDoctor(id, dto);
		return new ResponseEntity<DoctorDTO>(updatedto,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete-doctor/{id}")
	public ResponseEntity<ResponseMsg> deleteDoctor(@PathVariable Integer id) {
	  Boolean deletemsg=service.deleteDoctor(id);
	  if(deletemsg) {
		  ResponseMsg msg=new ResponseMsg("doctor is deleted", deletemsg);
		  return new ResponseEntity<ResponseMsg>(msg,HttpStatus.ACCEPTED);
	  }
	  else {
		  ResponseMsg msg=new ResponseMsg("doctor is not deleted", deletemsg);
		  return new ResponseEntity<ResponseMsg>(msg,HttpStatus.NOT_FOUND);
	  }
	}
	@GetMapping("/get-specialization")
	public ResponseEntity<List<DoctorDTO>> getDoctorBySpecialization(@RequestParam String specialization){
		List<DoctorDTO> doctordtos= service.getDoctorBySpecialization(specialization);
		return new ResponseEntity<List<DoctorDTO>>(doctordtos,HttpStatus.ACCEPTED);
	}
}
