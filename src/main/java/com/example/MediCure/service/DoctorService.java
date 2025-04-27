package com.example.MediCure.service;

import java.util.List;

import com.example.MediCure.payloads.DoctorDTO;
<<<<<<< HEAD
import com.example.MediCure.payloads.PatientDTO;
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35

public interface DoctorService {
DoctorDTO insertDoctor(DoctorDTO doctor,Integer id);
List<DoctorDTO> viewAllDoctor();
DoctorDTO getDoctorById(Integer id);
DoctorDTO updateDoctor(Integer id,DoctorDTO dto);
Boolean deleteDoctor(Integer id);
List<DoctorDTO> getDoctorBySpecialization(String specialization);
<<<<<<< HEAD
List<PatientDTO> getPatientsByDoctorId(Integer doctorId);
DoctorDTO insertPatients(Integer doctor_id,Integer patient_id,String specialization);
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35

}
