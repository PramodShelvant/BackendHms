package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OpdDiagnosisBean{
	
	
	 
	private int id;
	private int  patientId;
	private String reportType;
	private String description;
	private String reportDate;
	private MultipartFile document;


}
