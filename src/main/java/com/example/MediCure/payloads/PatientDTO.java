package com.example.MediCure.payloads;

import jakarta.validation.constraints.NotBlank;

public class PatientDTO {
	 @NotBlank(message = "Age is required")
	private Integer age;
	private String gender;
	 @NotBlank(message = "Address is required")
	private String address;
	 @NotBlank(message = "Phone Number is required")
	private Long phoneNumber;
	private String medicalhistory;
	private UserDTO user;
	public PatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDTO(Integer age, String gender, String address, Long phoneNumber, String medicalhistory,
			UserDTO user) {
		super();
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.medicalhistory = medicalhistory;
		this.user = user;
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
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
}
