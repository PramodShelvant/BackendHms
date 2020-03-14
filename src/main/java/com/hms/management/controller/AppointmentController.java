package com.hms.management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Object addAppointment(@RequestBody Appointment appointment) throws RecordNotFoundException{
		//System.out.println("hello");
		log.debug("appointment request:{}", appointment);
		return appointmentServiceImpl.bookAppointment(appointment);
		
	}
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/", produces = "application/json")
    public Object updaeAppointment(@RequestBody Appointment appointment) throws RecordNotFoundException{
		System.out.println("update");
		log.debug("appointment request:{}", appointment);
		return appointmentServiceImpl.update(appointment);
		
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
		System.out.println("HELLO");
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
	
	@CrossOrigin
	@RequestMapping(value = "/update/{appointStatus}", method = RequestMethod.PUT, produces = "application/json")
	public Object updateAppointment(@RequestBody Appointment appointment) {
		return appointmentServiceImpl.updateAppointmentByStatus(appointment);
		
	}
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteAppointment(@PathVariable int id) {
		return appointmentServiceImpl.deleteAppointment(id);
		
	}
	@CrossOrigin
	@RequestMapping(value = "/newappointment", method = RequestMethod.POST, produces = "application/json")
	public Object addNewAppointment(@RequestBody Appointment appointment) {
		System.out.println("sdfghjk");
 		return appointmentServiceImpl.addNewAppointment(appointment);
		
	}
	@CrossOrigin
	@RequestMapping(value = "onedayappointments/{date}", method = RequestMethod.GET, produces = "application/json")
     public List<Appointment> getByDate(@PathVariable String date) throws RecordNotFoundException {
		log.debug("appointment request:{}", date);
		return appointmentServiceImpl.getByDate(date);
	}
	
	@CrossOrigin
	@RequestMapping(value = "d/{date}", method = RequestMethod.GET, produces = "application/json")
     public Object findFirst10ByDate(@PathVariable String date) throws RecordNotFoundException {
		log.debug("appointment request:{}", date);
		return appointmentServiceImpl.getOneWeekAppointments(date);
	}
	@CrossOrigin
	@RequestMapping(value = "gettt",method = RequestMethod.GET,produces = "application/json")
	public List<Appointment> getAll(){
		return appointmentServiceImpl.getAll();
		
	}
}


