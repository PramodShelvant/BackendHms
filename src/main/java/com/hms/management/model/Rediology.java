package com.hms.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rediology")
public class Rediology {
	
	
	@Id
 	private String radiologyId;
 	private String testName;
	private String shortName;
	private String testType;
 	private String Code;
 	private String categoryName;
	private String subCategory;
	private String reportDays;
 	private String chargeCategory;
	private int chargeId;
 	private String standardCharge;
	private Date createdAt;
	private Date updatedAt;
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="billNo")
	 * 
	 * @ApiModelProperty(notes = "billNo") private RadiologyReport radiologyReport;
	 */
	
	
}
