package com.hms.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "setting_charges")
public class Setting_Charges {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	 private String chargeType;
	 private String chargeCategory;
	 private String  code;
	 private String  standardCharge;
	 private String   description;
	 @OneToMany(targetEntity = OrganisationsCharges.class,cascade = CascadeType.ALL)
	    @JoinColumn(name = "pid",referencedColumnName = "id",insertable = true, updatable = true, nullable=false)
	     private List<OrganisationsCharges> organisationCharges=new ArrayList<>();

}
