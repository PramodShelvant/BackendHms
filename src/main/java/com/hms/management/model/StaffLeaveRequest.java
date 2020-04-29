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
@Table(name = "staff_leave_request")

public class StaffLeaveRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int staffId;
	private int leaveTypeId;
	private String leaveFrom;
	private String leaveTo;
	private int leaveDays;
	private String employeeRemark;
	private String adminRemark;
	private String status;
	private String appliedBy;
	private String documentFile;
	private String date;
}
