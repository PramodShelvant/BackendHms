package com.hms.management.beans;

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
	private String date;
	private String inTime;
	private String outTime;
	private String action;
	private String numberOfPersons;
	private String idCard;
    private String note;
 	private MultipartFile attachedDocument;
}
