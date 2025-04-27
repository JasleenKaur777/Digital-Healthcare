package com.example.MediCure.entity;

<<<<<<< HEAD


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
=======
import com.example.MediCure.payloads.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
<<<<<<< HEAD
import jakarta.persistence.OneToMany;
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String specialization;
    @Column(unique = true)
    private String phone;
    private String email;
    
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    
<<<<<<< HEAD
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "doctor")
    private List<Patient> patients;
    
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
    public Doctor() {}

    public Doctor(Integer id, String name, String specialization, String phone, String email, User user) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.phone = phone;
		this.email = email;
		this.user = user;
	}

	public Doctor(Integer id, String name, String specialization, String phone, String email) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
    }

    
<<<<<<< HEAD
    public Doctor(Integer id, String name, String specialization, String phone, String email, User user,
			List<Patient> patients) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.phone = phone;
		this.email = email;
		this.user = user;
		this.patients = patients;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public User getUser() {
=======
    public User getUser() {
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
