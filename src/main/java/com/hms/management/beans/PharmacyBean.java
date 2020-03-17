package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import com.hms.management.model.Pharmacy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PharmacyBean{
	private int id;
	private String medicineName;
	private int medicineCategoryId;
	private MultipartFile medicineImage;
	private String medicineCompany;
	private String medicineComposition;
	private String medicineGroup;
	private String unit;
	private String minLevel;
	private String reorderLevel;
	private String vat;
	private String unitPacking;
	private String supplier;
	private String vatAc;
	private String note;
	private String createdAt;
	private String updatedAt;

}
