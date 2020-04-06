package com.hms.management.ambulance.model;

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
@Table(name = "vehiclecall")
public class Ambulancecall {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String patientName;
	private String contactNo;
	private String address;
	private int vehicleid;
	private String amount;
	private String date;
	private Date createdAt;
	private Date updatedAt;
}
