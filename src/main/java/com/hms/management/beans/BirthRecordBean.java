package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class BirthRecordBean {
	
	private int id;
	private String childName;
	private String gender;
	private String weight;
	private String birthDate;
	private String phone;
	private String address;
	private String motherName;
	private String ipdOrOpdNo;
	private String fatherName;
	private MultipartFile  childPhoto;
    private MultipartFile motherPhoto;
	private MultipartFile fatherPhoto;
	private MultipartFile attachDocument;

}
