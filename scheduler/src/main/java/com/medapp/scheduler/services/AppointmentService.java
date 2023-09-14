package com.medapp.scheduler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medapp.scheduler.model.Appointment;
import com.medapp.scheduler.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	
	@Autowired
	AppointmentRepository appointmentrepo;
	
	public List<Appointment> listAll(){
		return appointmentrepo.findAll();
	}
	
	public void save(Appointment appointment) {
		appointmentrepo.save(appointment);
	}

	public Appointment get(Long aid) {
		return appointmentrepo.findById(aid).get();
	}


}
