package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PatientRegistrationBean {

	
	private String patientId;
	private String patientName;
	private String gender;
	private String dateOfBirth;
	private String gurdianName;
	private String age;
	private String bloodGroup;
	private String maritalStatus;
	private MultipartFile PatientPhoto;
	private String phone;
	private String email;
	private String address;
	private String remarks;
	private String knownAllergies;
}
	
