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
@Table(name = "ConsultantInstruction")
public class ConsultantInstruction{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 	private String appliedDate;
	private String doctorId;
	private String doctorName;
	private String instruction;
	private String instructionDate;
	
}