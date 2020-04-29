package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.PatientRegistrationBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PatientRegistration;
import com.hms.management.serviceimpl.PatientRegistrationServiceImpl;


@CrossOrigin()
@RestController
@RequestMapping("/patientregistration")
public class PatientRegistrationController {

	
	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//D//";

	@Autowired
	public PatientRegistrationServiceImpl patientRegistrationServiceImpl;
	
	
	
	@CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object addPatientRegistration(PatientRegistrationBean patientRegistrationBean) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String, Object>();
		PatientRegistration n=new PatientRegistration();
        byte[] bytes = null;
		try {
			bytes = patientRegistrationBean.getPatientPhoto().getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + patientRegistrationBean.getPatientPhoto().getOriginalFilename());
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setPatientPhoto(UPLOADED_FOLDER + patientRegistrationBean.getPatientPhoto().getOriginalFilename());
  
	       // n.setPhoto(UPLOADED_FOLDER + patientRegistrationBean.getPhoto().getOriginalFilename());
	      //  n.setPatientId("P-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
	        Date d=new Date();
	        n.setUpdatedAt(d);
	        n.setCreatedAt(d);
            n.setAddress(patientRegistrationBean.getAddress());
            n.setAge(patientRegistrationBean.getAge());
            n.setBloodGroup(patientRegistrationBean.getBloodGroup());
            n.setDateOfBirth(patientRegistrationBean.getDateOfBirth());
            n.setEmail(patientRegistrationBean.getEmail());
            n.setGender(patientRegistrationBean.getGender());
            n.setGurdianName(patientRegistrationBean.getGurdianName());
            n.setKnownAllergies(patientRegistrationBean.getKnownAllergies());
            n.setMaritalStatus(patientRegistrationBean.getMaritalStatus());
            n.setPatientId(patientRegistrationBean.getPatientId());
            n.setPatientName(patientRegistrationBean.getPatientName());
            n.setRemarks(patientRegistrationBean.getPhone());
            n.setPhone(patientRegistrationBean.getRemarks());
            return patientRegistrationServiceImpl.addPatientRegistration(n);
		
	}
    @CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
	public List<PatientRegistration> getAllpatientregistration(){
		return patientRegistrationServiceImpl.getAllPatientRegistration();
		
	}
    @CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deletePatientRegistration(PatientRegistration patientRegistration) {
		return patientRegistrationServiceImpl.deletePatientRegistration(patientRegistration);
		
	}
    
    public PatientRegistration adPatientRegistration(@RequestBody PatientRegistration patientRegistration) {
		return patientRegistrationServiceImpl.adPatientRegistration(patientRegistration);
    	
    }
}







