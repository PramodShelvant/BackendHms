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
@Table(name = "item_stock")

public class ItemStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int itemId;
	private int supplierId;
	private String symbol;
	private int storeId;
	private int quantity;
	private String date;
	private String attachment;
	private String description;
	private String isActive;
	private String createdAt;
}
