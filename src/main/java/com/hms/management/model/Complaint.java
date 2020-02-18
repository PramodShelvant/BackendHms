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
@Table(name = "complaint")

public class Complaint 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String complaintType; 
	private String source;
	private String name;
	private String contact;
	private String email;
	private String date;
	private String description;
	private String actionTaken;
	private String assigned;
	private String note;
	private String image;

}
