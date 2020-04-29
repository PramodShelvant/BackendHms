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
@Table(name = "ComplainType")
public class ComplainType {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String complainBy;
	private String source;
	private String phone;
	private String date;
	private String description;
	private String actionTaken;
	private String assigned;
	private String note;
	private String attachedDocument;
}
