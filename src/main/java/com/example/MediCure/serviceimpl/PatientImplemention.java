package com.example.MediCure.serviceimpl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MediCure.dao.PatientRepository;
import com.example.MediCure.dao.UserRepository;
import com.example.MediCure.entity.Patient;
import com.example.MediCure.entity.User;
import com.example.MediCure.exception.ResourceNotFoundException;
import com.example.MediCure.payloads.PatientDTO;
import com.example.MediCure.service.PatientService;

@Service
public class PatientImplemention implements PatientService {
	
	@Autowired
	UserRepository user_repo;
	
	@Autowired
	PatientRepository patient_repo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public PatientDTO createPatient(Integer userid, PatientDTO dto) {
		 User user = user_repo.findById(userid)
			        .orElseThrow(() -> new ResourceNotFoundException("User", "User id", userid));
		 if (user.getRole().equalsIgnoreCase("patient")) {
			 Patient patient=new Patient();
			 patient.setAddress(dto.getAddress());
			 patient.setAge(dto.getAge());
			 patient.setGender(dto.getGender());
			 patient.setMedicalhistory(dto.getMedicalhistory());
			 patient.setPhoneNumber(dto.getPhoneNumber());
			 patient.setUser(user);
			 Patient patient_insert=patient_repo.save(patient);
			 return mapper.map(patient_insert, PatientDTO.class);
		 }
		 else {
			 
			        throw new ResourceNotFoundException("User", "User is not patient role", userid);
			 
		 }
		
	}

	@Override
	public List<PatientDTO> getAllPatient() {
	List<Patient> patients=	patient_repo.findAll();
	List<PatientDTO> dtos=patients.stream().map(patient->mapper.map(patient, PatientDTO.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public PatientDTO getPatientById(Integer id) {
	Patient patient=	patient_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "Patient id", id));
		return mapper.map(patient, PatientDTO.class);
	}

	@Override
	public PatientDTO updatePatient(Integer id, PatientDTO dto) {
		Patient patient=patient_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "Patient id", id));
		if(patient!=null) {
			patient.setAddress(dto.getAddress());
			patient.setAge(dto.getAge());
			patient.setGender(dto.getGender());
			patient.setMedicalhistory(dto.getMedicalhistory());
			patient.setPhoneNumber(dto.getPhoneNumber());
			patient_repo.save(patient);
		}
		return mapper.map(patient, PatientDTO.class);
	}

	@Override
	public Boolean deletePatient(Integer id) {
		Patient patient=patient_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "Patient id", id));
		if(patient!=null) {
			patient_repo.delete(patient);
			return true;
		}
		else {
			return false;
		}
		
	}

}
