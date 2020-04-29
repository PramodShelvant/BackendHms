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
@Table(name = "DeathRecord")
public class DeathRecord {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String PatientName;
	private String ipdOrOpdNo;
	private String deathDate;
	private String guardianName;
	private String report;
	private String recieverName;
	
}
