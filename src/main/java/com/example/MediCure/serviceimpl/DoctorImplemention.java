package com.example.MediCure.serviceimpl;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
=======
import java.util.List;
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MediCure.dao.DoctorRepository;
<<<<<<< HEAD
import com.example.MediCure.dao.PatientRepository;
import com.example.MediCure.dao.UserRepository;
import com.example.MediCure.entity.Doctor;
import com.example.MediCure.entity.Patient;
import com.example.MediCure.entity.User;
import com.example.MediCure.exception.ResourceNotFoundException;
import com.example.MediCure.payloads.DoctorDTO;
import com.example.MediCure.payloads.PatientDTO;
import com.example.MediCure.payloads.ResponseMsg;
=======
import com.example.MediCure.dao.UserRepository;
import com.example.MediCure.entity.Doctor;
import com.example.MediCure.entity.User;
import com.example.MediCure.exception.ResourceNotFoundException;
import com.example.MediCure.payloads.DoctorDTO;
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
import com.example.MediCure.service.DoctorService;

@Service
public class DoctorImplemention implements DoctorService {
<<<<<<< HEAD

	@Autowired
	UserRepository user_repo;

	@Autowired
	PatientRepository patient_repo;

=======
	
	@Autowired
	UserRepository user_repo;
	
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
	@Autowired
	DoctorRepository doctor_repo;

	@Autowired
	ModelMapper mapper;
<<<<<<< HEAD

	@Override
	public DoctorDTO insertDoctor(DoctorDTO doctor, Integer id) {
		User user = user_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "User id", id));

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
=======
	
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
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
	}

	@Override
	public List<DoctorDTO> viewAllDoctor() {
<<<<<<< HEAD
	    List<Doctor> doctors = doctor_repo.findAll();
	    List<DoctorDTO> doctorDtos = new ArrayList<>();

	    for (Doctor doctor : doctors) {
	        DoctorDTO doctorDto = mapper.map(doctor, DoctorDTO.class);

	        List<PatientDTO> patientDtos = new ArrayList<>();
	        if (doctor.getPatients() != null) {
	            patientDtos = doctor.getPatients()
	                .stream()
	                .map(patient -> mapper.map(patient, PatientDTO.class))
	                .collect(Collectors.toList());
	        }

	        doctorDto.setPatientdtos(patientDtos);
	        doctorDtos.add(doctorDto);
	    }

	    return doctorDtos;
=======
		List<Doctor> doctors=doctor_repo.findAll();
		List<DoctorDTO> doctordtos=  doctors.stream().map(doctor->mapper.map(doctor, DoctorDTO.class)).collect(Collectors.toList());
		return doctordtos;
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
	}

	@Override
	public DoctorDTO getDoctorById(Integer id) {
<<<<<<< HEAD
	    Doctor doctor = doctor_repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", id));
	    
	    

	    DoctorDTO doctorDto = mapper.map(doctor, DoctorDTO.class);

	    List<PatientDTO> patientDtos = new ArrayList<>();
	    if (doctor.getPatients() != null) {
	        patientDtos = doctor.getPatients()
	            .stream()
	            .map(patient -> mapper.map(patient, PatientDTO.class))
	            .collect(Collectors.toList());
	    }

	    doctorDto.setPatientdtos(patientDtos);
	    return doctorDto;
	}


	@Override
	public DoctorDTO updateDoctor(Integer id, DoctorDTO dto) {
		Doctor doctor = doctor_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", id));
=======
		Doctor doctor=doctor_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor", "Doctor id", id));
		
		return mapper.map(doctor, DoctorDTO.class);
	}

	@Override
	public DoctorDTO updateDoctor(Integer id,DoctorDTO dto) {
		Doctor doctor=doctor_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor", "Doctor id", id));
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
		doctor.setPhone(dto.getPhone());
		doctor.setSpecialization(dto.getSpecialization());
		doctor_repo.save(doctor);
		return mapper.map(doctor, DoctorDTO.class);
	}

	@Override
	public Boolean deleteDoctor(Integer id) {
<<<<<<< HEAD
		Doctor doctor = doctor_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", id));
		if (doctor != null) {
			doctor_repo.delete(doctor);
			return true;
		} else {
			return false;
		}

=======
		Doctor doctor=doctor_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor", "Doctor id", id));
		if(doctor!=null) {
			doctor_repo.delete(doctor);
			return true;
		}
		else {
			return false;
		}
		
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
	}

	@Override
	public List<DoctorDTO> getDoctorBySpecialization(String specialization) {
<<<<<<< HEAD
		List<Doctor> doctors = doctor_repo.findBySpecialization(specialization);
		List<DoctorDTO> doctorsdto = doctors.stream().map(doctor -> mapper.map(doctor, DoctorDTO.class))
				.collect(Collectors.toList());
=======
		List<Doctor> doctors= doctor_repo.findBySpecialization(specialization);
		List<DoctorDTO> doctorsdto=doctors.stream().map(doctor->mapper.map(doctor, DoctorDTO.class)).collect(Collectors.toList());
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
		return doctorsdto;
	}


<<<<<<< HEAD
	@Override
	public DoctorDTO insertPatients(Integer doctor_id, Integer patient_id, String specialization) {
	    Doctor doctor = doctor_repo.findById(doctor_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", doctor_id));

	    if (!doctor.getSpecialization().equalsIgnoreCase(specialization)) {
	        throw new ResourceNotFoundException("Doctor", "Specialization mismatch", doctor_id);
	    }

	    Patient patient = patient_repo.findById(patient_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Patient", "Patient id", patient_id));

	    patient.setDoctor(doctor);
	    patient_repo.save(patient);

	    List<Patient> patients = Optional.ofNullable(doctor.getPatients()).orElse(new ArrayList<>());
	    patients.add(patient);
	    doctor.setPatients(patients);
	    doctor_repo.save(doctor);

	    List<PatientDTO> patientDtos = patients.stream()
	            .map(user -> mapper.map(user, PatientDTO.class))
	            .collect(Collectors.toList());

	    DoctorDTO doctorDto = mapper.map(doctor, DoctorDTO.class);
	    doctorDto.setPatientdtos(patientDtos);

	    return doctorDto;
	}

	public List<PatientDTO> getPatientsByDoctorId(Integer doctorId) {
        Doctor doctor = doctor_repo.findById(doctorId)
            .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", doctorId));

        List<Patient> patients = doctor.getPatients();
        return patients.stream()
                .map(patient -> mapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }
=======
	
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35

}
