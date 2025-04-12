package com.example.MediCure.payloads;

public class DoctorDTO {
	private Integer id;
	
    private String specialization;
    private String phone;
   
	public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorDTO(Integer id, String specialization, String phone) {
		super();
		this.id = id;
		this.specialization = specialization;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
    
}
