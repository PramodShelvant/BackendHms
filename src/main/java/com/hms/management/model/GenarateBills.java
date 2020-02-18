package com.hms.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GenarateBills")
public class GenarateBills {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int pid;
    private int billNo;
    private String date;
    private String medicineCategory;
    private String medicineName;
    private String batchNo;
    private String expireDate;
    private String quantity;
     private float salePrice;
    private float amount;
    private String hospitalDoctor;
    private String doctorName;
    private String note;
    private float total;
    private float discount;
    private float tax;
    private float netAmount;


}
