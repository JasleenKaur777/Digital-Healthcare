package com.example.MediCure.service;

import java.util.List;

import com.example.MediCure.payloads.DoctorDTO;

public interface DoctorService {
DoctorDTO insertDoctor(DoctorDTO doctor,Integer id);
List<DoctorDTO> viewAllDoctor();
DoctorDTO getDoctorById(Integer id);
DoctorDTO updateDoctor(Integer id,DoctorDTO dto);
Boolean deleteDoctor(Integer id);
List<DoctorDTO> getDoctorBySpecialization(String specialization);

}
