package com.hms.management.model;

import java.sql.Date;

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
	private int patientId;
	private int discount;
	private String otherCharge;
	private String date;
	private int tax;
	private String grossTotal;
	private float netAmount;
	private int totalAmount;
	private int generatedBy;
	private String status;
}
