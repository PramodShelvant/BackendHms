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
@Table(name = "ipd_billing")

public class IpdBilling {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String patientId;
	private float discount;
	private float otherCharge;
	private String date;
	private float tax;
	private float grossTotal;
	private float netAmount;
	private float totalAmount;
	private String generatedBy;
	private String status;
}
