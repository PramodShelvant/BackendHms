package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PostalRecieveList")
public class PostalRecieveList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fromTitle;
	private String referenceNo;
	private String toTitle;
	private String date;
	private String note;
	private String address;
	private String attachdocument;
  }
