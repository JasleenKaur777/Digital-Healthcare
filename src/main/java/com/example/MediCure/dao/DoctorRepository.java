package com.example.MediCure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MediCure.entity.Doctor;
import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
List<Doctor> findBySpecialization(String specialization);
<<<<<<< HEAD

=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
}
