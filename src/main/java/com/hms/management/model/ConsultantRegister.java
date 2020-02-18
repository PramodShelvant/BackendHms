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
@Table(name = "consultant_register")

public class ConsultantRegister
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int patientId;
	private String date;
	private String insDate;
	private String instruction;
	private int consDoctor;
}