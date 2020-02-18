package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MedicianBean {

  	private int id;
	private String medicineName;
	private String medicineCategory;
	private String medicineCompany;
	private String medicineComposition;
	private String medicineGroup;
	private String unit;
	private String minLevel;
	private String reOrderLevel;
	private String vat;
	private String packing;
	private String vatAc;
	private String note;
	private MultipartFile MedicinePhoto;
}
