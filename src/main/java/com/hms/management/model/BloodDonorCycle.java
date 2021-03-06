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
@Table(name = "blood_donor_cycle")

public class BloodDonorCycle
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int bloodDonorId;
	private String institution;
	private String lot;
	private String bagNo;
	private String quantity;
	private String donateDate;
	private String createdAt;
	private String updatedAt;

}
