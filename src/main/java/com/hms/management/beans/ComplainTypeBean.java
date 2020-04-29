package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class ComplainTypeBean {

	
  	private int id;
	private String complainBy;
	private String source;
	private String phone;
	private String date;
	private String description;
	private String actionTaken;
	private String assigned;
	private String note;
	private MultipartFile attachedDocument;
	
	
}