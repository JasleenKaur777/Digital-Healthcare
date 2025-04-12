package com.example.MediCure.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
private String email;
private String medicalhistory;
private Date registerationDate;
public Patient() {
	super();
}

public Patient(Integer id, Integer age, String gender, String address, Long phoneNumber, String email,
		String medicalhistory, Date registerationDate) {
	super();
	this.id = id;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.medicalhistory = medicalhistory;
	this.registerationDate = registerationDate;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMedicalhistory() {
	return medicalhistory;
}
public void setMedicalhistory(String medicalhistory) {
	this.medicalhistory = medicalhistory;
}
public Date getRegisterationDate() {
	return registerationDate;
}
public void setRegisterationDate(Date registerationDate) {
	this.registerationDate = registerationDate;
}


}
