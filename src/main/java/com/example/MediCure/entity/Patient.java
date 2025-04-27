package com.example.MediCure.entity;

import java.util.Date;

<<<<<<< HEAD
import jakarta.persistence.CascadeType;
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
<<<<<<< HEAD
import jakarta.persistence.ManyToOne;
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private Integer age;
private String gender;
private String address;
private Long phoneNumber;
private String medicalhistory;

<<<<<<< HEAD
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="user_id")
private User user;

@ManyToOne(cascade = CascadeType.ALL)
private Doctor doctor;

=======
@OneToOne
@JoinColumn(name="user_id")
private User user;

>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
public Patient() {
	super();
	// TODO Auto-generated constructor stub
}

public Patient(Integer id, Integer age, String gender, String address, Long phoneNumber, String medicalhistory,
		User user) {
	super();
	this.id = id;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.medicalhistory = medicalhistory;
	this.user = user;
}

<<<<<<< HEAD

public Patient(Integer id, Integer age, String gender, String address, Long phoneNumber, String medicalhistory,
		User user, Doctor doctor) {
	super();
	this.id = id;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.medicalhistory = medicalhistory;
	this.user = user;
	this.doctor = doctor;
}

public Doctor getDoctor() {
	return doctor;
}

public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Long getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getMedicalhistory() {
	return medicalhistory;
}

public void setMedicalhistory(String medicalhistory) {
	this.medicalhistory = medicalhistory;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}



}
