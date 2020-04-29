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
@Table(name = "BillSummery")
public class BillSummery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String opdId;
	private float consultantCharge;
	private float totalCharge;
	private float otherCharge;
	private float discount;
	private float discountpercentage;
 	private float taxpercentage;
	private float tax;
	private float grosstotal;
	private float totalPayment;
	private float netPayableAmount;
}
