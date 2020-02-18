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
 @Table(name = "PhoneCallLogList")
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class PhoneCallLogList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  	private int id;
	private String name;
	private String date;
	private String phone;
	private String nextFallowUpDate;
	private String description;
	private String callDuretion;
	private String callType;
	private String note;
	
}
