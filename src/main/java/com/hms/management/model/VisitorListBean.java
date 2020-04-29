package com.hms.management.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class VisitorListBean {

	
  	private int id;
	private String purpose;
	private String name;
	private String phone;
	private Date date;
	private String intime;
	private String outtime;
	private String action;
	private String note;
 	private MultipartFile attachedDocument;
}
