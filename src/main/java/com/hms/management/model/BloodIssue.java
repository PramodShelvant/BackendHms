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
@Table(name = "blood_issue")

public class BloodIssue{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String dateOfIssue;
	private String recieveTo;
	private String bloodGroup;
	private String gender;
	private String doctor;
	private String institution;
	private String technician;
	private float amount;
	private String donorName;
	private String lot;
	private String bagNo;
	private String remark;
	private Date createdAt;
	private Date updatedAt;
}


