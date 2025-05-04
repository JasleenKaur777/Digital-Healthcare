package com.example.MediCure.service;

import java.util.List;

import com.example.MediCure.payloads.AppointmentDTO;

public interface AppointmentService {
	AppointmentDTO createAppointment(AppointmentDTO dto,Integer doctorid,Integer patientid);
    AppointmentDTO updateAppointmentStatus(Integer id, String status);
    List<AppointmentDTO> getAppointmentsByPatientId(Integer patientId);
    List<AppointmentDTO> getAppointmentsByDoctorId(Integer doctorId);
    AppointmentDTO getAppointmentById(Integer id);
    Boolean deleteAppointment(Integer id);
}
