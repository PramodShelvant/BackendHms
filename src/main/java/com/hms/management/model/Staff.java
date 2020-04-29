package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "staff")
public class Staff {
	
	
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
	private String photo;
	private String Specialization;
	private String note;
	private String permnentAddress;
	private String currentAddrees;
	private String accountTitle;
	private String bankName;
	private String bankBranchName;
	private String accountNumber;
	private String ifscCode;

 	
 	
	
 }
