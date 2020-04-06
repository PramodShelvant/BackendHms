package com.hms.management.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hms.management.EmailSender;
import com.hms.management.model.Appointment;
import com.hms.management.model.UserRegistration;
import com.hms.management.repository.MyAppointmentRepo;
import com.hms.management.repository.UserRegistrationRepository;
@CrossOrigin
@RestController
@RequestMapping("myappointment")
public class MyAppointmentController {
	
	@Autowired
	private MyAppointmentRepo appointmentRepo;
	
	@Autowired
	private UserRegistrationRepository userRepo;
	

	@PostMapping("/add")
	public <T> T add(@RequestBody Appointment s) {
			if(s.getPatientId().isEmpty()) {
				if(userRepo.findByEmail(s.getEmail()).size()>0) {
					Map map=new HashMap<>();
					map.put("err", "emailid arready exist");
					return (T) map;
				}
				UserRegistration u=new UserRegistration();
				u.setEmail(s.getEmail());
				u.setGender(s.getGender());
				u.setMobileNo(s.getMobileNumber());
				u.setName(s.getPatientName());
				u.setPassword("pat"+String.valueOf(new Random().nextInt()).substring(0, 5));
				u.setRole("patient");
				u.setUserId("pat"+"-"+DateTimeFormatter.ofPattern("yyyyMMddHHmmssa").format(LocalDateTime.now()));
				s.setPatientId(u.getUserId());
				//if(userRepo.findByEmail(s.getEmail()).size()>0)
				userRepo.save(u);
				EmailSender.sendMail("revanhj1993@gmail.com", "sunday14031993", "userName:"+s.getEmail()+" password:"+u.getPassword(), s.getEmail());
			}else {
				Optional<Appointment> a= appointmentRepo.findByPatientId(s.getPatientId()).stream().findFirst();
				if(!a.isEmpty()) {
					Appointment app=a.get();
					s.setMobileNumber(app.getMobileNumber());
					s.setAddress(app.getAddress());
					s.setEmail(app.getEmail());
					s.setGender(app.getGender());
					s.setPatientName(app.getPatientName());
				}
				else {
					Map map=new HashMap<>();
					map.put("err", "invalid patientId");
					return (T) map;
				}
			}
			
			
			s.setAptId("apt"+"-"+DateTimeFormatter.ofPattern("yyyyMMddHHmmssa").format(LocalDateTime.now()));	
		return (T)appointmentRepo.save(s);
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T)appointmentRepo.findAll();
	}
	
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		appointmentRepo.deleteById(id);
		return (T)(""+id);
	}
	
	
	

}
