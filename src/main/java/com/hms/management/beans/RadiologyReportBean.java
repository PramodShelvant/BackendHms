package com.hms.management.beans;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class RadiologyReportBean {

	
	
	private int billNo;
	private int radiologyId;
	private String patientId;
	private String customerType;
	private String patientName;
	private String consultantDoctor;
	private String reportingDate;
	private String description;
	private MultipartFile radiologyReport;
	private float applyCharge;
	private Date createdAt;
	private Date updatedAt;

}
