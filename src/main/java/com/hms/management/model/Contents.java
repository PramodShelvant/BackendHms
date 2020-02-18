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
@Table(name = "contents")

public class Contents 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title; 
	private String type;
	private String isPublic;
	private int classId;
	private int clsSecId;
	private String file;
	private int createdBy;
	private String note;
	private String isActive;
	private String createdAt;
	private String updatedAt;
	private String date;

}
