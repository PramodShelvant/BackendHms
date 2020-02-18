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
@Table(name = "charges")

public class Charges {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String chargeType; 
	private String chargeCategory;
	private String description;
	private String code;
	private String standardCharge;
	private String date;
	private String status;

}