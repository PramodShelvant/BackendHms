package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "IpdDiagnosis")
public class IpdDiagnosis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int  patientId;
	private String reportType;
	private String document;
	private String description;
	private String reportDate;
}
