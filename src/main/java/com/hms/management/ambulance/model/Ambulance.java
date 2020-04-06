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
@Table(name = "vehicle")
public class Ambulance{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String vehicleNo;
	private String vehicleModel;
	private String manufactureYear;
	private String vehicleType;
	private String driverName;
	private String driverLicence;
	private String driverContact;
	private String note;
	private String createdAt;
	}



