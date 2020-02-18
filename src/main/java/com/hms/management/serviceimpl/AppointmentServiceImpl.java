package com.hms.management.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Appointment;
import com.hms.management.repository.AppointmentRepo;
import com.hms.management.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	
	@Autowired
	AppointmentRepo appointmentRepo;

	
	@Override
	public Appointment bookAppointment(Appointment appointment) throws RecordNotFoundException{
 		Date d=new Date();
 		appointment.setAptId("APTID-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
        appointment.setCreatedAt(d);
		appointment.setUpdatedAt(d);
        return appointmentRepo.save(appointment);
 	    
	}

	@Override
	public Appointment getAppointment(int id) throws RecordNotFoundException {
	 return appointmentRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("No appointment record exist for given id"));
	}

	@Override
	public List<Appointment> getAllAppointment() throws RecordNotFoundException {
 		return appointmentRepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}

	@Override
	public List<Map<String, Object>> getbookAppointment(String aptId) throws RecordNotFoundException {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Map<String, Object>> al=new ArrayList<Map<String, Object>>();
		//String aptId= appointment.getAptId();
 		     List<Appointment> a=appointmentRepo.findByAptId(aptId);
		     if(a.size()!=0) {
		    	 map.put("msg", a);
		    	 al.add(map);
 
		     }else {
		    	 map.put("msg", appointmentRepo.findAll());
		    	 al.add(map);
					return al;

		    	 }
			return al;
 	}

	@Override
	public List<Appointment> getPatientId(String patientId) throws RecordNotFoundException {
 		return appointmentRepo.findByPatientId(patientId);
	}

	@Override
	public List<Appointment> getByDoctorId(String doctorId) throws RecordNotFoundException {
 		return appointmentRepo.findByDoctorId(doctorId);
	}
		 
}
