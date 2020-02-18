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
@Table(name = "expenses")

public class FinanceExpenses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int expHeadId;
	private String name;
	private String invoiceNo;
	private String date;
	private float amount;
	private String documents;
	private String note;
	private String isActive;
	private String isDeleted;
	private String description;
	private Date createdAt;
	private Date updatedAt;
}
