package com.example.MediCure.service;

import java.util.List;

import com.example.MediCure.payloads.PatientDTO;

public interface PatientService {
PatientDTO createPatient(Integer userid,PatientDTO dto);
List<PatientDTO> getAllPatient();
PatientDTO getPatientById(Integer id);
PatientDTO updatePatient(Integer id,PatientDTO dto);
Boolean deletePatient(Integer id);
}
