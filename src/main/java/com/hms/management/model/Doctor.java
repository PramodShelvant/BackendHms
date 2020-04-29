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
@Table
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String doctorId;
	private String phoneNo;
	private String firstName;
	private String lastName;
 	private String addressline1;
 	private String addressLine2;
	private String qualification;
	private String  expenducture;
	private String password;
	private String Specilist;
	
}
