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
@Table(name = "staff_payroll")

public class StaffPayroll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int basicSalary;
	private String payScale;
	private String grade;
	private String isActive;
}
