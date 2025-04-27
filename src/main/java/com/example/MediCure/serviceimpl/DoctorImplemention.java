package com.example.MediCure.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MediCure.dao.UserRepository;
import com.example.MediCure.dao.PatientRepository;
import com.example.MediCure.dao.DoctorRepository;
import com.example.MediCure.entity.Patient;
import com.example.MediCure.entity.User;
import com.example.MediCure.entity.Doctor;
import com.example.MediCure.exception.ResourceNotFoundException;
import com.example.MediCure.payloads.DoctorDTO;
import com.example.MediCure.payloads.PatientDTO;
import com.example.MediCure.service.DoctorService;

@Service
public class DoctorImplemention implements DoctorService {

    @Autowired
    UserRepository user_repo;

    @Autowired
    PatientRepository patient_repo;

    @Autowired
    DoctorRepository doctor_repo;

    @Autowired
    ModelMapper mapper;

    @Override
    @Transactional
    public DoctorDTO insertDoctor(DoctorDTO doctor, Integer id) {
        User user = user_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "User id", id));

        if (!user.getRole().equalsIgnoreCase("doctor")) {
            throw new ResourceNotFoundException("User", "User is not doctor role", id);
        }

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
    }

    @Override
    public List<DoctorDTO> viewAllDoctor() {
        List<Doctor> doctors = doctor_repo.findAll();
        List<DoctorDTO> doctorDtos = new ArrayList<>();

        for (Doctor doctor : doctors) {
            DoctorDTO doctorDto = mapper.map(doctor, DoctorDTO.class);

            List<PatientDTO> patientDtos = doctor.getPatients() != null ? doctor.getPatients()
                    .stream()
                    .map(patient -> mapper.map(patient, PatientDTO.class))
                    .collect(Collectors.toList()) : new ArrayList<>();

            doctorDto.setPatientdtos(patientDtos);
            doctorDtos.add(doctorDto);
        }

        return doctorDtos;
    }

    @Override
    public DoctorDTO getDoctorById(Integer id) {
        Doctor doctor = doctor_repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", id));

        DoctorDTO doctorDto = mapper.map(doctor, DoctorDTO.class);

        List<PatientDTO> patientDtos = doctor.getPatients() != null ? doctor.getPatients()
                .stream()
                .map(patient -> mapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList()) : new ArrayList<>();

        doctorDto.setPatientdtos(patientDtos);
        return doctorDto;
    }

    @Override
    public DoctorDTO updateDoctor(Integer id, DoctorDTO dto) {
        Doctor doctor = doctor_repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", id));

        doctor.setPhone(dto.getPhone());
        doctor.setSpecialization(dto.getSpecialization());
        doctor_repo.save(doctor);

        return mapper.map(doctor, DoctorDTO.class);
    }

    @Override
    @Transactional
    public Boolean deleteDoctor(Integer id) {
        Doctor doctor = doctor_repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", id));

        doctor_repo.delete(doctor);
        return true;
    }

    @Override
    public List<DoctorDTO> getDoctorBySpecialization(String specialization) {
        List<Doctor> doctors = doctor_repo.findBySpecialization(specialization);
        return doctors.stream()
                .map(doctor -> mapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
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
                .map(p -> mapper.map(p, PatientDTO.class))
                .collect(Collectors.toList());

        DoctorDTO doctorDto = mapper.map(doctor, DoctorDTO.class);
        doctorDto.setPatientdtos(patientDtos);

        return doctorDto;
    }

    @Override
    public List<PatientDTO> getPatientsByDoctorId(Integer doctorId) {
        Doctor doctor = doctor_repo.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Doctor id", doctorId));

        return doctor.getPatients().stream()
                .map(patient -> mapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }
}
