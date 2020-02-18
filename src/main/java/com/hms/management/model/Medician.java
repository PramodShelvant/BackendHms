package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "medician")
public class Medician {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private String note;
	private String vatAc;
	private String MedicinePhoto;
 }
