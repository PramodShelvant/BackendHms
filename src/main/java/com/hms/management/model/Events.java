package com.hms.management.model;

import java.sql.Date;

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
@Table(name = "events")

public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String eventTitle;
	private String eventDescription;
	private String startDate;
	private String endDate;
	private String eventType;
	private String eventColor;
	private String eventFor;
	private String isActive;
	
	
}
