package com.hms.management.humanresource.modal;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "humanResource")
@Table(name="human_Resorce")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {
@Id
private String staffId;
private String role;
private int departmentId;
private int designationId;
private String firstName;
private String lastName;
private String fatherName;
private String motherName;
private String gender;
private String maritalStatus;
private String bloodGroup;
@DateTimeFormat(pattern ="yyyy-MM-dd")
private String dateOfBirth;
@DateTimeFormat(pattern ="yyyy-MM-dd")
private String dateOfJoining;
private String phone;
private String email;
private String photo;
private String qualification;
private String workExperiance;
private String currentAddress;  
private String permanentAddress;
private String specialization;
private String note;
//pay roll
private String epfNum;
private String basicSalary;
private String contractType;
private String workShift;
private String location;
//bank details
private String accountTitle;
private String bankAccountNumber;
private String bankName;
private String ifscCode;
private String bankBranchName;
//social media link
private String facebookUrl;
private String twitterUrl;
private String instagramUrl;
private String linkedInUrl;
//upload document
private String resume;
private String joiningLetter;
private String otherDocuments;



}
