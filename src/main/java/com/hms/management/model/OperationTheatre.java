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
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "OperationTheatre")
public class OperationTheatre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String patientId;
 	private String operationName;
	private Date operationDate;
	private String operationType;
	private String patientName;
 	private String consultantDoctor;
	private String assConsultant1;
	private String assConsultant2;
	private String anesthetist;
	private String anesthetistType;
	private String otTechnician;
	private String otAssistant;
	private String tpa;
	private String action;
 	private String selectCtegory;;
	private String code;
	private String standardCharge;
	private String appliedCharge;
	private String height;
	private String weight;
	private String bp;
	private String note;
	private String symptoms;
	private Date createdAt;
	private Date updatedAt;
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="uId")
	 * 
	 * @ApiModelProperty(notes = "uId") private UserRegistration userRegistration;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name="billId")
	 * 
	 * @ApiModelProperty(notes = "billId") private RadiologyReport radiologyReport;
	 */}
