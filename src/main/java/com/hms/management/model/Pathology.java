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
@Table(name = "pathology")

public class Pathology {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String patientId;
	private String testName;
	private String shortName;
	private String testType;
	private String categoryName;
	private String unit;
	private String subCategory;
	private String reportDays;
	private String method;
	private String chargeCategory;
	private String code;
	private String standardCharge;
	private Date createdAt;
	private Date updatedAt;
}
