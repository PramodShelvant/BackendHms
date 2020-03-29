package com.hms.management.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private String opdId;
	private String chargeType; 
	private String chargeCategory;
	private String description;
	private String code;
	private String standardCharge;
	private String date;
	private String appliedCharge;
	private String tpaCharge;
	private String status;
}