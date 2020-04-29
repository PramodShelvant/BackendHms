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
@Table(name = "FinanceIncome")

public class FinanceIncome {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//private int incHeadId;
	private String name;
	private String invoiceNo;
	private Date date;
	private float amount;
	private String note;
 	private Date createdAt;
	private Date updatedAt;
	private String documents;
	
	
	@OneToOne
	@JoinColumn(name="incHeadId")
	@ApiModelProperty(notes = "incHeadId")
	private IncomeHead incomeHead;

}
