package com.example.MediCure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MediCure.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
