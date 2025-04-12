package com.example.MediCure.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MediCure.dao.DoctorRepository;
import com.example.MediCure.dao.UserRepository;
import com.example.MediCure.entity.Doctor;
import com.example.MediCure.entity.User;
import com.example.MediCure.exception.ResourceNotFoundException;
import com.example.MediCure.payloads.DoctorDTO;
import com.example.MediCure.payloads.UserDTO;
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


	

}
