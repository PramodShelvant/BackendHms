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
@Table(name = "payslip_allowance")

public class PayslipAllowance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int payslipId;
	private String allowanceType;
	private int amount;
	private int staffId;
	private String calType;
}
