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
@Table(name = "item")

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int itemCategoryId;
	private String name;
	private String itemPhoto;
	private String description;
	private String createdAt;
	private String updatedAt;
	private int itemStoreId;
	private int itemSupplierId;
	private int quantity;
	private String date;
}
