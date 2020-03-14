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
@Table(name = "PatientDischarge")
public class PatientDischarge {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String patientId;
	private String gender;
	private String phone;
	private String consultant;
	private String admissionbDate;
	private String disChargeDate;
	private float charge;
	private float otherCharges;
	private float tax;
	private float discount;
	private float paidAmount;
	
	
}
