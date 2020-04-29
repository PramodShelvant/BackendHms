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
@Table(name = "staff_payslip")

public class StaffPayslip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int staffId;
	private int basic;
	private int totalAllowance;
	private int totalDeduction;
	private int leaveDeduction;
	private String tax;
	private float netSalary;
	private String status;
	private String month;
	private String year;
	private String paymentMode;
	private String paymentDate;
	private String remark;
}
