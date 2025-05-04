package com.example.MediCure.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer appointmentId;

	    @ManyToOne
	    @JoinColumn(name = "patient_id")
	    private Patient patient;

	    @ManyToOne
	    @JoinColumn(name = "doctor_id")
	    private Doctor doctor;

	    private LocalDate date;
	    private LocalTime time;

	    @Enumerated(EnumType.STRING)
	    private Status status;

	    public enum Status {
	        PENDING, APPROVED, CANCELLED
	    }

		public Appointment() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Appointment(Integer appointmentId, Patient patient, Doctor doctor, LocalDate date, LocalTime time,
				Status status) {
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

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
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

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}
	    
}
