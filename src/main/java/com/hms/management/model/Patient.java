
  package com.hms.management.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Patient") 
public class Patient {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id; 
  private int pid;
  private String admissiondate; 
  private String patientname;
  private String age; 
  private String month;
  private Blob image;
  private String mobilenumber;
  private String emil; 
  private String dateOfbirth; 
  private String maritalstatus; 
  private String bloodgroup;
  private String guardianaddress; 
  private String guardianemail; 
  private String isactive; 
  private String patienttype;
  private String creditlimit; 
  private String organisation; 
  private String oldpatient;
  private String createdat;
  private String updatedat;
  private String disableat; 
  private String note;
    
  }
 