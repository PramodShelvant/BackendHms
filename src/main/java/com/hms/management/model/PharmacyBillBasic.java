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
@Table(name = "pharmacy_bill_basic")
public class PharmacyBillBasic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String billNo;
	private String date;
	private String patientId;
	private String customerName;
	private String customerType;
	private String doctorName;
	private String opdIpdNo;
	private String total;
	private String discount;
	private String tax;
	private float netAmount;
	private String note;
	private String createdAt;
	private String updatedAt;
}
