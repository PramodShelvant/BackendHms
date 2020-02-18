package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pharmacy")

public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String medicineName;
	private String medicineCategoryId;
	private String medicineImage;
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
