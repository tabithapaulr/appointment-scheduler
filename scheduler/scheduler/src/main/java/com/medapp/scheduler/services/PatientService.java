package com.medapp.scheduler.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medapp.scheduler.model.Patient;
import com.medapp.scheduler.repository.PatientRepository;


@Service
public class PatientService {

	@Autowired
	private PatientRepository patientrepo;
	
	
	public List<Patient> listAll(){
		return patientrepo.findAll();
	}
	
    public Patient getPatientById(Long id) {
        return patientrepo.findById(id).orElse(null);
    }
	
	public void save(Patient patient) {
		patientrepo.save(patient);
	}
	
	
	public Patient get(Long id) {
		return patientrepo.findById(id).get();
	}
	
	public void deletePatient(Long pid) {
	    Optional<Patient> patientOptional = patientrepo.findById(pid);
	    if (patientOptional.isPresent()) {
	        Patient patient = patientOptional.get();
	        patientrepo.delete(patient);
	    }
	}
	
}
