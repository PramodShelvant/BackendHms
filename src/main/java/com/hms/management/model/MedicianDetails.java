package com.hms.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "medicianDetails")
public class MedicianDetails {

 	@Id
 	@GeneratedValue
 	private int mid;
  	private String billNo;
	private String patientId;
	private String date;
	private String doctor;
	private String hospitalDoctor;
	private String note;
	private float discount;
	private float tax;
	private float netAmount;
	 
       @OneToMany(targetEntity = MedicineCategory.class,cascade = CascadeType.ALL)
       @JoinColumn(name = "mc_fk",referencedColumnName = "mid",insertable = true, updatable = true, nullable=false)
       private List<MedicineCategory> medicineCategory=new ArrayList<MedicineCategory>();
}


