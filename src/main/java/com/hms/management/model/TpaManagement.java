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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "TpaManagement")
public class TpaManagement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String code;
	private String phone;
	private String address;
	private String contactPersonName;
	private String contactpersonPhone;
	private Date createdAt;
	private Date updatedAt;
}
