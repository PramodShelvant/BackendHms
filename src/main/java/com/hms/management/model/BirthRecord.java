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
@Table
public class BirthRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String childName;
	private String gender;
	private String weight;
	private String birthDate;
	private String phone;
	private String address;
	private String motherName;
	private String ipdOrOpdNo;
	private String fatherName;
	private String  childPhoto;
    private String motherPhoto;
	private String fatherPhoto;
	private String attachDocument;
}
