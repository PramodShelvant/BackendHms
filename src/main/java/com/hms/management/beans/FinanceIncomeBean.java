package com.hms.management.beans;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FinanceIncomeBean {
	
	
  	private int id;
	private String incHeadId;
	private String name;
	private String invoiceNo;
	private String date;
	private float amount;
	private String note;
 	private Date createdAt;
	private Date updatedAt;
	private MultipartFile documents;
	
}