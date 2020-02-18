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
@Table(name = "staff")

public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String employeeId;
	private String department;
	private String designation;
	private String qualification;
	private String workExp;
	private String specialization;
	private String name;
	private String surname;
	private String fatherName;
	private String motherName;
	private String contactNo;
	private String emergencyContactNo;
	private String email;
	private String dob;
	private String maritalStatus;
	private String dateOfJoining;
	private String dateOfLeaving;
	private String localAddress;
	private String permanentAddress;
	private String note;
	private String image;
	private String password;
	private String gender;
	private String bloodGroup;
	private String accountTitle;
	private String bankAccountNo;
	private String bankName;
	private String ifscCode;
	private String bankBranch;
	private String payscale;
	private String basicSalary;
	private String epfNo;
	private String contractType;
	private String shift;
	private String location;
	private String facebook;
	private String twitter;
	private String linkedin;
	private String instagram;
	private String resume;
	private String joiningLetter;
	private String resignationLetter;
	private String otherDocumentName;
	private String otherDocumentFile;
	private int userId;
	private int isActive;
	private String verificationCode;
}
