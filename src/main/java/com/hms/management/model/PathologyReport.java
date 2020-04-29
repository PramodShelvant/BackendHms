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
@Table(name = "pathology_report")
public class PathologyReport {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billNo;
 	private String patientId;
	private String customerType;
	private String patientName;
	private String consultantDoctor;
 	private Date reportingDate;
	private String description;
	private String pathologyReport;
	private String action;
	private float  applyCharge;
	private Date createdAt;
	private Date updatedAt;
	
	@OneToOne
	@JoinColumn(name="pathologyId")
	@ApiModelProperty(notes = "pathologyId")
	private Pathology pathology;
	
	
	//Starting from 1st day of the current month till now.
	//SELECT * FROM hospitalManagement.pathology_report WHERE  reporting_date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()

	//Starting from 1st Jan of the current Year till now.
	// SELECT * FROM hospitalManagement.pathology_report WHERE  reporting_date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()


	//last 7days records
	//select * from hospitalManagement.pathology_report where  `reporting_date` >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)


	
	
}
