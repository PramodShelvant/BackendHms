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
@Table(name = "OpdDetail")
public class OpdOutPatient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String patientId;
	private String opdId;
  	private String appointmentDate;
	private String caseType;
	private String casuality;
	private String Symptoms; 
	private String bp;
	private String oldPatient;
	private String height;
	private String weight;
 	private String tpa;
	private String consDoctor;
	private String standardCharge;
	private String appliedCharge;
	private String paymentMode;
 	private String note;
	
		
	
}

