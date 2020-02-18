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
@Table(name = "ambulance_call")
public class AmbulanceCall {
	
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String patienName;
		private String contactNo;
		private String address;
		private String vehicleNo;
		private String vehicleModel;
		private String driver;
		private float amount;
		private String date;
		private Date createdAt;
		private Date updatedAt;
	}



