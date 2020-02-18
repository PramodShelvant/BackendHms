package com.hms.management.model;

import java.util.Date;

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
@Table (name = "appointment")
public class Appointment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String aptId;
    private String patientId;
 	private String appointmentNo;
	private String date;
	private String patientName;
	private String gender;
	private String email;
	private String mobileNumber;
	private String doctorId;
	private String message;
	private String appointmentStatus;
	private String source;
	private String department;
 	private Date createdAt;
 	private Date updatedAt;
 	
}