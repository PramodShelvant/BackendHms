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
@Table(name = "PurchaseMedician")
public class PurchaseMedician {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String medicianCategory;
	private String medicianName;
	private int batchNo;
	private String expireDate;
	private float MRP;
	private float batchAmount;
	private float salePrice;
	private String packagingQty;
	private String quentity;
	private String packagingPrice;
	private float amount;
	private float total;
	private float discount;
	private float tax;
	private float netAmount;
	private String note;
	private String attachDocument;
	
}
