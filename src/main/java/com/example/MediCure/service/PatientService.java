package com.example.MediCure.service;

import com.example.MediCure.payloads.PatientDTO;

public interface PatientService {
PatientDTO createPatient(Integer userid,PatientDTO dto);
}
