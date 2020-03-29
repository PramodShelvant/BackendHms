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
@Table(name = "organisation")
public class Organisation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String organisationName;
	private String code;
	private String contactNo;
	private String address;
	private String contactPersonName;
	private String contactPersonPhone;
}
