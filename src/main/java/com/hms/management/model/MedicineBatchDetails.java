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
@Table
public class MedicineBatchDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int pharmacyId;
	private String medicineName;
	private int medicineCategoryId;
	private String medicineCategory;
	private String batchamt;
	private String inwardDate;
	private String expiryDate;
	private String batchNum;
	private String packingqty;
	private String purchasePrice;
	private float quantity;
	private float mrp;
	private float saleprice;
	private float amount;
	private float availableQuantity;
	private String createdAt;
	private String updatedAt;
}
