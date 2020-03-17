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
@Table(name = "medicine_bad_stock")
public class MedicineBadStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int pharmacyId;
	private String outwardDate;
	private String expiryDate;
	private String batchNo;
	private String quantity;
	private String note;
}
