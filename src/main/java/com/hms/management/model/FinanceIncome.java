package com.hms.management.model;

 
import java.util.Date;

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
@Table(name = "FinanceIncome")

public class FinanceIncome {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String incHeadId;
	private String name;
	private String invoiceNo;
	private String date;
	private float amount;
	private String note;
 	private Date createdAt;
	private Date updatedAt;
	private String documents;
}
