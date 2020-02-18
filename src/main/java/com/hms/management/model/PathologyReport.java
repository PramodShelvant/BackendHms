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
@Table(name = "pathology_report")
public class PathologyReport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int pathologyId;
	private String patientId;
	private String customerType;
	private String patientName;
	private String consultantDoctor;
	private String reportingDate;
	private String description;
	private String pathologyReport;
	private float applyCharge;
	private String createdAt;
	private String updatedAt;
}
