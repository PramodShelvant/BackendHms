package com.hms.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "radiology_report")

public class RadiologyReport {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billNo;
 	private String patientId;
	private String customerType;
	private String patientName;
	private String consultantDoctor;
	private Date reportingDate;
	private String description;
	private String radiologyReport;
	private float applyCharge;
	private Date createdAt;
	private Date updatedAt;
	
	@OneToOne
	@JoinColumn(name="radiologyId")
	@ApiModelProperty(notes = "radiologyId")
	private Rediology radiology;

	
}
