package com.hms.management.humanresource.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class StaffLeave {
	@Id
	@GeneratedValue
	private int id;
	private String staffId;
	private String applyDate;
	private String toDate;
	private String fromDate;
	private String role;
	private int leaveTypeId;
	private String reason;
	private String attachDocument;
	private String note;
	private String status;
	

}
