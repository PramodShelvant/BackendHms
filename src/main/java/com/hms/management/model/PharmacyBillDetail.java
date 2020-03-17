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
@Table(name = "pharmacy_bill_detail")
public class PharmacyBillDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String pharmacyBillBasicId;
	private int medicineCategoryId;
	private String medicineName;
	private String expireDate;
	private String batchNo;
	private String quantity;
	private String salePrice;
	private float amount;
}
