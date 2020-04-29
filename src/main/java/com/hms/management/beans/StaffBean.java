package com.hms.management.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

 
 @Setter
 @Getter
public class StaffBean {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String staffId;
	private String role;
	private String firstName;
	private String lastName;
	private String gender;
	private String maritalStatus;
	private String dateOfJoining;
	private String phone;
	private String qualification;
	private String workExperiance;
	private String designation;
	private String department;
	private String fatherName;
	private String motherName;
	private String bloodGroup;
	private String dateOfBirth;
	private String email;
	private MultipartFile photo;
	private String Specialization;
	private String note;
	private String permnentAddress;
	private String currentAddress;
	private String accountTitle;
	private String bankName;
	private String bankBranchName;
	private String accountNumber;
	private String ifscCode;
	 
	}
