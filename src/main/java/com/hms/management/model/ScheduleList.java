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
@Table
@Entity(name = "ScheduleList")
public class ScheduleList {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String slno;
	private String doctorName;
	private String department;
	private String doctorId;
	private String day;
	private String startTime;
	private String endTime;
	private String perPatientTime;
	private String status;
	private String action;
	
	
	
	
}
