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
@Table(name = "radio")

public class Radio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String testName;
	private String shortName;
	private String testType;
	private String radiologyCategoryId;
	private String subCategory;
	private String reportDays;
	private int chargeId;
	private String createdAt;
	private String updatedAt;
}
