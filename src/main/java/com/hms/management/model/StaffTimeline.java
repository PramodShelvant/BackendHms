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
@Table(name = "staff_timeline")

public class StaffTimeline {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int staffId;
	private String title;
	private String timelineDate;
	private String description;
	private String document;
	private String status;
	private String date;
}
