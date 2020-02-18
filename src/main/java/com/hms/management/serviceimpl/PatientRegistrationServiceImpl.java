package com.hms.management.serviceimpl;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.PatientRegistration;
import com.hms.management.model.UserRegistration;
import com.hms.management.repository.UserRegistrationRepository;
import com.hms.management.service.PatientRegistrationService;

@Service
public class PatientRegistrationServiceImpl implements PatientRegistrationService {

	
	@Autowired
	public PatientRegistrationRepository patientRegistrationRepository;
	
	@Autowired
	public UserRegistrationRepository userRegistrationRepository;
 
	@Override
	public PatientRegistration addPatientRegistration(PatientRegistration patientRegistration) {
		patientRegistration.setPatientId("P-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
		UserRegistration u=new UserRegistration();
		u.setUserProfile(patientRegistration.getPatientPhoto());
		u.setEmail(patientRegistration.getEmail());
		u.setMobileNo(patientRegistration.getPhone());
		u.setRole("patient");
		u.setPassword("123456");
		Date d=new Date();
		u.setSignupDate(d);
		u.setName(patientRegistration.getPatientName());
 		u.setUserId(patientRegistration.getPatientId());
		userRegistrationRepository.save(u);
 	   return patientRegistrationRepository.save(patientRegistration);
	}

	 
	@Override
	public List<PatientRegistration> getAllPatientRegistration() {
 		return patientRegistrationRepository.findAll();
	}
}
