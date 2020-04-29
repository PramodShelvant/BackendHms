package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostalDisPatchListBean {

	 
	private int id;
	private String fromTitle;
	private String referenceNo;
	private String toTitle;
	private String address;
	private String note;
	private String date;
	private MultipartFile attachdDocument;
}
