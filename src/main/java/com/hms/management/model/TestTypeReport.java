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
@Table(name = "test_type_report")

public class TestTypeReport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int radiologyId;
	private String type;
	private String testName;
	private String reportingDate;
	private String description;
	private String testReport;
	private String createdAt;
	private String updatedAt;
}
