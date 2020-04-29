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
@Table(name = "dispatch_receive")

public class DispatchReceive 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String referenceNo;
	private String toTitle;
	private String address;
	private String note;
	private String fromTitle;
	private String date;
	private String image;
	private String createdAt;
	private String  updatedAt;
	private String type;

}
