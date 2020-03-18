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
@Table(name = "purchaseMedicineModal")
public class PurchaseMedicineModal {
 	@Id
 	@GeneratedValue
 	private int id;
	private String supplierId;
	private String date;
	private String note;
	private float discount;
	private float tax;
	private float netamount;
	private String attachDocument;
	private float total;
	@OneToMany(targetEntity = MedicineBatchDetails.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "mc_fk",referencedColumnName = "id",insertable = true, updatable = true, nullable=false)
    private List<MedicineBatchDetails> medicine=new ArrayList<MedicineBatchDetails>();

}