package com.hms.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PatientRegistration")
public class PatientRegistration {

	@Id
	private String patientId;
	private String patientName;
	private String gender;
	private String dateOfBirth;
	private String gurdianName;
	private String age;
	private String bloodGroup;
	private String maritalStatus;
	private String PatientPhoto;
	private String phone;
	private String email;
	private String address;
	private String remarks;
	private String knownAllergies;
	private Date createdAt;
	private Date updatedAt;
	
	
	
}
