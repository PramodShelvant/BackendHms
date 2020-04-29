package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ReciptionistProfile")
public class ReciptionistProfile {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String role;
 	private String staffId;
	private String designetion;
	private String reciptionistProfile;
	private String department;
	private int epfNo;
	private float basicSalary;
	private String cotractType;
	private String workShift;
	private String location;
	private String dateOfJoining;
	private String phone;
	private String emergencyContactNo;
	private String email;
	private String gender;
	private String bloodGroup;
	private String dateOfBirth;
	private String maritalStatus;
	private String fatherName;
	private String motherName;
	private String quelification;
	private String workExperience;
	private String specilization;
	private String currentAddress;
	private String permnentAddress;
	private String note;
	
}
