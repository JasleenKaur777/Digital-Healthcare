package com.example.MediCure.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MediCure.dao.AppointmentRepository;
import com.example.MediCure.dao.DoctorRepository;
import com.example.MediCure.dao.PatientRepository;
import com.example.MediCure.entity.Appointment;
import com.example.MediCure.entity.Doctor;
import com.example.MediCure.entity.Patient;
import com.example.MediCure.exception.ResourceNotFoundException;
import com.example.MediCure.payloads.AppointmentDTO;
import com.example.MediCure.service.AppointmentService;

@Service
public class AppointmentImplemention implements AppointmentService {
	 @Autowired
	    private AppointmentRepository appointmentRepo;

	    @Autowired
	    private DoctorRepository doctorRepo;

	    @Autowired
	    private PatientRepository patientRepo;

	    @Autowired
	    private ModelMapper mapper;
	
	@Override
	public AppointmentDTO createAppointment(AppointmentDTO dto,Integer doctorid,Integer patientid) {
		Doctor doctor=doctorRepo.findById(doctorid).orElseThrow(()->new ResourceNotFoundException("doctor", "doctor id", doctorid));
		Patient patient=patientRepo.findById(patientid).orElseThrow(()->new ResourceNotFoundException("patient", "patient id", patientid));
		
			Appointment app=new Appointment();
			app.setDoctor(doctor);
			app.setPatient(patient);
			app.setDate(dto.getDate());
			app.setTime(dto.getTime());
			app.setStatus(Appointment.Status.PENDING);
			Appointment saved = appointmentRepo.save(app);
	        return mapper.map(saved, AppointmentDTO.class);
		
	}

	@Override
	public AppointmentDTO updateAppointmentStatus(Integer id, String status) {
		Appointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "ID", id));

        appointment.setStatus(Appointment.Status.valueOf(status.toUpperCase()));
        appointmentRepo.save(appointment);

        return mapper.map(appointment, AppointmentDTO.class);
		
	}

	@Override
	public List<AppointmentDTO> getAppointmentsByPatientId(Integer patientId) {
		 Patient patient=patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("patient", "patient id", patientId));
		 List<Appointment> appointments=appointmentRepo.findByPatient(patient);
	        return appointments.stream().map(a -> mapper.map(a, AppointmentDTO.class)).collect(Collectors.toList());
	    
	}

	@Override
	public List<AppointmentDTO> getAppointmentsByDoctorId(Integer doctorId) {
		Doctor doctor=doctorRepo.findById(doctorId).orElseThrow(()->new ResourceNotFoundException("doctor", "doctor id", doctorId));
		 List<Appointment> appointments=appointmentRepo.findByDoctor(doctor);
		 return appointments.stream().map(a -> mapper.map(a, AppointmentDTO.class)).collect(Collectors.toList());
	}

	@Override
	public AppointmentDTO getAppointmentById(Integer id) {
		 Appointment appointment = appointmentRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "ID", id));
	        return mapper.map(appointment, AppointmentDTO.class);
	}

	@Override
    public Boolean deleteAppointment(Integer id) {
        Appointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "ID", id));
        appointmentRepo.delete(appointment);
        return true;
    }

}
