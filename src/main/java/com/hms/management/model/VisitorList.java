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

@Entity
@Table(name = "VisitorList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorList {

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int id;
	private String purpose;
	private String name;
	private String phone;
	private Date date;
	private String inTime;
	private String outTime;
	private String action;
	private String numberOfPersons;
	private String idCard;
    private String note;
 	private String attachedDocument;
}
