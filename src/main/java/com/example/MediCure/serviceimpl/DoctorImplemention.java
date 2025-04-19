package com.example.MediCure.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MediCure.dao.DoctorRepository;
import com.example.MediCure.dao.UserRepository;
import com.example.MediCure.entity.Doctor;
import com.example.MediCure.entity.User;
import com.example.MediCure.exception.ResourceNotFoundException;
import com.example.MediCure.payloads.DoctorDTO;
import com.example.MediCure.service.DoctorService;

@Service
public class DoctorImplemention implements DoctorService {
	
	@Autowired
	UserRepository user_repo;
	
	@Autowired
	DoctorRepository doctor_repo;

	@Autowired
	ModelMapper mapper;
	
	@Override
	public DoctorDTO insertDoctor(DoctorDTO doctor, Integer id) {
	    User user = user_repo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("User", "User id", id));
	    
	    if (user.getRole().equalsIgnoreCase("doctor")) {
	      
	        Doctor doct = new Doctor();
	        doct.setEmail(user.getEmail());
	        doct.setName(user.getUsername());
	        doct.setPhone(doctor.getPhone());
	        doct.setSpecialization(doctor.getSpecialization());
	        doct.setUser(user);

	        Doctor savedDoctor = doctor_repo.save(doct);

	        
	        user.setDoctor(savedDoctor);
	        user_repo.save(user);  

	        return mapper.map(savedDoctor, DoctorDTO.class);
	    } else {
	        throw new ResourceNotFoundException("User", "User is not doctor role", id);
	    }
	}

	@Override
	public List<DoctorDTO> viewAllDoctor() {
		List<Doctor> doctors=doctor_repo.findAll();
		List<DoctorDTO> doctordtos=  doctors.stream().map(doctor->mapper.map(doctor, DoctorDTO.class)).collect(Collectors.toList());
		return doctordtos;
	}

	@Override
	public DoctorDTO getDoctorById(Integer id) {
		Doctor doctor=doctor_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor", "Doctor id", id));
		
		return mapper.map(doctor, DoctorDTO.class);
	}

	@Override
	public DoctorDTO updateDoctor(Integer id,DoctorDTO dto) {
		Doctor doctor=doctor_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor", "Doctor id", id));
		doctor.setPhone(dto.getPhone());
		doctor.setSpecialization(dto.getSpecialization());
		doctor_repo.save(doctor);
		return mapper.map(doctor, DoctorDTO.class);
	}

	@Override
	public Boolean deleteDoctor(Integer id) {
		Doctor doctor=doctor_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor", "Doctor id", id));
		if(doctor!=null) {
			doctor_repo.delete(doctor);
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public List<DoctorDTO> getDoctorBySpecialization(String specialization) {
		List<Doctor> doctors= doctor_repo.findBySpecialization(specialization);
		List<DoctorDTO> doctorsdto=doctors.stream().map(doctor->mapper.map(doctor, DoctorDTO.class)).collect(Collectors.toList());
		return doctorsdto;
	}


	

}
