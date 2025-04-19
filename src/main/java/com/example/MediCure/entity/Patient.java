package com.example.MediCure.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

@OneToOne
@JoinColumn(name="user_id")
private User user;

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
