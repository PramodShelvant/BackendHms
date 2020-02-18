package com.hms.management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Appointment;
import com.hms.management.serviceimpl.AppointmentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin()
@RestController
@RequestMapping("appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public Appointment addAppointment(@RequestBody Appointment appointment) throws RecordNotFoundException{
		log.debug("appointment request:{}", appointment);
		return appointmentServiceImpl.bookAppointment(appointment);
		
	}
	
	/*
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces =
	 * "application/json") public Appointment getAppointment(@PathVariable int id)
	 * throws RecordNotFoundException { log.debug("appointment request:{}", id);
	 * 
	 * //Map<String,Object> map=new HashMap<String,Object>();
	 * //map.put("details of appointment",
	 * appointmentServiceImpl.getAppointment(id)); return
	 * appointmentServiceImpl.getAppointment(id); }
	 */
	
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
	 public List<Appointment> getAllAppointment() throws RecordNotFoundException {
		log.debug("appointment request:{}");
     return appointmentServiceImpl.getAllAppointment();
    }
	
	@CrossOrigin
	@RequestMapping(value = "/appointment/{aptId}", method = RequestMethod.GET, produces = "application/json")
	 public List<Map<String, Object>> getAllOrOne(@PathVariable String aptId) throws RecordNotFoundException {
		log.debug("appointment request:{}");
     return appointmentServiceImpl.getbookAppointment(aptId);
    }
	@CrossOrigin
	@RequestMapping(value = "patient/{patientId}", method = RequestMethod.GET, produces = "application/json")
     public List<Appointment> getByPatientId(@PathVariable String patientId) throws RecordNotFoundException {
		log.debug("appointment request:{}", patientId);
		return appointmentServiceImpl.getPatientId(patientId);
	}
	@CrossOrigin
	@RequestMapping(value = "doctor/{doctorId}", method = RequestMethod.GET, produces = "application/json")
     public List<Appointment> getByDoctorId(@PathVariable String doctorId) throws RecordNotFoundException {
		log.debug("appointment request:{}", doctorId);
		return appointmentServiceImpl.getByDoctorId(doctorId);
	}
	
}


