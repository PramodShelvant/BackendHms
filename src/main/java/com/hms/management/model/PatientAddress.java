
  package com.hms.management.model;
  
  import javax.persistence.Entity; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id;
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
  @Table(name = "PatientAddress") 
  public class PatientAddress {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) 
  private int id;
  private String adressLine;
  private String adressLine2; 
  private String taluk;
  private String district;
  private String state;
  private String pincode;
  
  
}
 