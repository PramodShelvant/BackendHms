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
@Table(name = "follow_up")

public class FollowUp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private int enquiryId;
	private String date;
	private String nextDate;
	private String response;
	private String note;
	private String followupBy;
}
