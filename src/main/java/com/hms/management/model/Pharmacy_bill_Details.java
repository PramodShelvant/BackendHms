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
@Table(name = "pharmacyBill_Details")
public class Pharmacy_bill_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 	private int medicineCategoryId;
 	private String medicineCategory;
	private int pharmacyId;
	private String medicineName;
	private String batchNum;
	private String expiryDate;
	private float quantity;
	private float saleprice;
	private float amount;
	private int medicineBatch;
}
