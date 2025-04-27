package com.example.MediCure.payloads;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
public class DoctorDTO {
	private Integer id;
	
    private String specialization;
    private String phone;
   
    private UserDTO user;
<<<<<<< HEAD
    private List<PatientDTO> patients=new ArrayList<PatientDTO>();
=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
   
	public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorDTO(Integer id, String specialization, String phone,String email) {
		super();
		this.id = id;
		this.specialization = specialization;
		this.phone = phone;
		
	}

	

<<<<<<< HEAD
	public DoctorDTO(Integer id, String specialization, String phone, UserDTO user, List<PatientDTO> patients) {
		super();
		this.id = id;
		this.specialization = specialization;
		this.phone = phone;
		this.user = user;
		this.patients = patients;
	}

	public List<PatientDTO> getPatientdtos() {
		return patients;
	}

	public void setPatientdtos(List<PatientDTO> patients) {
		this.patients = patients;
	}

=======
>>>>>>> 8a51cf9a6b60acb256e48f237ec6c9461f440a35
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

	
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
    
}
