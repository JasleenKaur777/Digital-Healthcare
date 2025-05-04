package com.example.MediCure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MediCure.payloads.AppointmentDTO;
import com.example.MediCure.payloads.ResponseMsg;
import com.example.MediCure.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	 @Autowired
	    private AppointmentService appointmentService;

	    @PostMapping("/")
	    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO dto,@RequestParam Integer doctorid,@RequestParam Integer patientid) {
	        return new ResponseEntity<>(appointmentService.createAppointment(dto,doctorid,patientid), HttpStatus.CREATED);
	    }
	    @PutMapping("/appointmentid/{id}/status")
	    public ResponseEntity<AppointmentDTO> updateStatus(@PathVariable Integer id, @RequestParam String status) {
	        return ResponseEntity.ok(appointmentService.updateAppointmentStatus(id, status));
	    }
	    @GetMapping("/appointments/patient/{patientId}")
	    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByPatient(@PathVariable Integer patientId) {
	        List<AppointmentDTO> list = appointmentService.getAppointmentsByPatientId(patientId);
	        return ResponseEntity.ok(list);
	    }
	    @GetMapping("/doctor/{doctorId}")
	    public ResponseEntity<List<AppointmentDTO>> getByDoctor(@PathVariable Integer doctorId) {
	        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctorId(doctorId));
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<AppointmentDTO> getById(@PathVariable Integer id) {
	        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseMsg> delete(@PathVariable Integer id) {
	       Boolean b= appointmentService.deleteAppointment(id);
	       if(b) {
	    	   return new ResponseEntity<ResponseMsg>(new ResponseMsg("Appointment deleted successfully!!!", true),HttpStatus.ACCEPTED);
	       }
	       else {
	       return new ResponseEntity<ResponseMsg>(new ResponseMsg("Appointment not deleted successfully!!!", true),HttpStatus.BAD_REQUEST);
	       }
	    }

}
