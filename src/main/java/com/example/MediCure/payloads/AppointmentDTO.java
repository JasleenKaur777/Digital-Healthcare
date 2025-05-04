package com.example.MediCure.payloads;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDTO {
	
	    private Integer appointmentId;
	    private PatientDTO patient;
	    private DoctorDTO doctor;
	    private LocalDate date;
	    private LocalTime time;
	    private String status;
		public AppointmentDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AppointmentDTO(Integer appointmentId, PatientDTO patient, DoctorDTO doctor, LocalDate date,
				LocalTime time, String status) {
			super();
			this.appointmentId = appointmentId;
			this.patient = patient;
			this.doctor = doctor;
			this.date = date;
			this.time = time;
			this.status = status;
		}
		public Integer getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(Integer appointmentId) {
			this.appointmentId = appointmentId;
		}
		public PatientDTO getPatient() {
			return patient;
		}
		public void setPatient(PatientDTO patient) {
			this.patient = patient;
		}
		public DoctorDTO getDoctor() {
			return doctor;
		}
		public void setDoctor(DoctorDTO doctor) {
			this.doctor = doctor;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public LocalTime getTime() {
			return time;
		}
		public void setTime(LocalTime time) {
			this.time = time;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
	    
	

}
