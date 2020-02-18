package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpdDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String height;
	private String weight;
	private String bp;
	private String ipdNo;
	private String room;
	private String bed;
	private String bedGroup;
	private String bedNo;
	private String caseType;
	private String casualty;
	private String symptoms;
	private String knownAllergies;
	private String refference;
	private String consultantDoctor;
	private String creditsLimit;
	private String amount;
	private String tax;
	private String paymentMode;
	private String date;
		
	
}
