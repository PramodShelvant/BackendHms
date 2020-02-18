package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostalRecieveListBean {
 
		 
 		private int id;
		private String fromTitle;
		private String referenceNo;
		private String toTitle;
		private String date;
		private String note;
		private String address;
		private MultipartFile attachDocument;
	}
