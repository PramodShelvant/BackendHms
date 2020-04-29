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
@Table(name = "medicine_batch_details")

public class MedicineBatchDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int pharmacyId;
	private String inwardDate;
	private String expiryDate;
	private String batchNo;
	private String packingQty;
	private String purchaseRatePacking;
	private String quantity;
	private String mrp;
	private String saleRate;
	private String amount;
	private String availableQuantity;
	private String createdAt;
	private String updatedAt;
}
