package com.medapp.scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.medapp.scheduler.model.Appointment;
import com.medapp.scheduler.model.Patient;
import com.medapp.scheduler.services.AppointmentService;
import com.medapp.scheduler.services.PatientService;



@Controller
public class AppController {

	@Autowired
	PatientService patservice;
	
	@Autowired
	AppointmentService appservice; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Patient> patientList = patservice.listAll();
		List<Appointment> appointmentList  = appservice.listAll();
		model.addAttribute("appointmentList", appointmentList);
		model.addAttribute("patientList", patientList); //given to display on html
		return "index";

	}
	
	@RequestMapping("/view")
	public String viewAppointment(Model model) {
		List<Patient> patientList = patservice.listAll();
		List<Appointment> appointmentList  = appservice.listAll();
		model.addAttribute("appointmentList", appointmentList);
		model.addAttribute("patientList", patientList); //given to display on html
		return "viewapp";

	}
  
  
	
	
	@RequestMapping("/new")
	public String newPatientPage(Model model) {
		
		Patient patient = new Patient();
		Appointment appoinment = new Appointment();
		model.addAttribute(patient);
		model.addAttribute(appoinment);
		return "new_appointment";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePatient(@ModelAttribute ("patient") Patient patient, @ModelAttribute("appointment") Appointment appointment) {
		patservice.save(patient);
	    // Set patient ID for appointment
	    appointment.setAid(patient.getPid());
	    appointment.setPatient(patient);
	    // Save appointment
	    appservice.save(appointment);
		return "redirect:/";
	}
	


//	@RequestMapping("edit/{pid}")
//	public String showEditPatientPage(@PathVariable(name = "pid") Long pid, @ModelAttribute("patient") Patient patient, @ModelAttribute("appointment") Appointment appointment, Model model) {
//	    patient = patservice.get(pid);
//	    
//	    if (patient != null) {
//	        List<Appointment> appointments = patient.getAppointments();
//	        for (Appointment appoint : appointments) {
//	            Long aid = appoint.getAid();
//	            appointment = appservice.get(aid);
//	            if (appointment != null) {
//	                model.addAttribute("appointment", appointment);
//	                model.addAttribute("patient", patient);
//	                	                               
//	                return "edit";
//	            }
//	         }
//	        
//	        
//	    }
//	                         
//	       
//	    	    
//	    return "redirect:/";
//	}
//	

	
	@RequestMapping("delete/{pid}")
	public String deletePatientAppointment(@PathVariable Long pid) {
		patservice.deletePatient(pid);
		return "redirect:/";
	}
	
	
	
	
}
