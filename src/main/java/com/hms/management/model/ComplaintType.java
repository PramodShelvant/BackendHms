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
@Table(name = "complaint_type")

public class ComplaintType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String complaintType;
	private String description;
	private String createdAt;


}
