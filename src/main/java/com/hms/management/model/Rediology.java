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
@Table(name = "Rediology")

public class Rediology {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String testName;
	private String shortName;
	private String testType;
 	private String Code;
 	private String categoryName;
	private String subCategory;
	private String reportDays;
 	private String chargeCategory;
 	private String standardCharge;
	private Date createdAt;
	private Date updatedAt;
}
