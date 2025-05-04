package com.example.MediCure.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MediCure.entity.Appointment;
import com.example.MediCure.entity.Doctor;
import com.example.MediCure.entity.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	List<Appointment> findByPatient(Patient patient);
	List<Appointment> findByDoctor(Doctor doctor);
}
