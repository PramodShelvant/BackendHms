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
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="doctorOpdCharge")
public class DoctorOpdCharge {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String doctorId;
	private String doctorName;
	private float standardCharge;
	 @OneToMany(targetEntity = DoctorCharges.class,cascade = CascadeType.ALL)
	    @JoinColumn(name = "pid",referencedColumnName = "id",insertable = true, updatable = true, nullable=false)
	     private List<DoctorCharges> organisationCharges=new ArrayList<>();

}
