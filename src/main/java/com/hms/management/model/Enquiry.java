package com.hms.management.model;

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
@Table(name = "enquiry")

public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String contact;
	private String address;
	private String reference;
	private String date;
	private String description;
	private String followUpDate;
	private String note;
	private String source;
	private String email;
	private String assigned;
	private int clas;
	private String noOfChild;
	private String status;
}
