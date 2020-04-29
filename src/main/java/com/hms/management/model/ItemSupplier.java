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
@Table(name = "item_supplier")

public class ItemSupplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String itemSupplier;
	private String phone;
	private String email;
	private String address;
	private String contactPersonName;
	private String contactPersonPhone;
	private String contactPersonEmail;
	private String description;
}
