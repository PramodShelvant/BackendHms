package com.hms.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "pharmacyBill_Basic")
public class Pharmacy_Bill_Basic {

 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
 	private int id;
	private String patientId;
	private String patientName;
	private String date;
	private String doctor;
	private String doctorName;
	private String note;
	private float discount;
	private float tax;
	private float total;
	private float netamount;
    @OneToMany(targetEntity = Pharmacy_bill_Details.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pid",referencedColumnName = "id",insertable = true, updatable = true, nullable=false)
    private List<Pharmacy_bill_Details> medicine=new ArrayList<Pharmacy_bill_Details>();
}


