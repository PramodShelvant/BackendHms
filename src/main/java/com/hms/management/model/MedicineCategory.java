package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicine_category")

public class MedicineCategory {
	
	@Id
 	private String medicianCatId;
	private String medicineCategory;
	private String medicianName;
	private String expiredate;
	private String quentity;
	private String salePrice;
	private float charges;
	 
}
