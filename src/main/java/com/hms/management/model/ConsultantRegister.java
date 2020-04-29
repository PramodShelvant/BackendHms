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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consultant_register")

public class ConsultantRegister{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 	private String ipdId;
	
 	
 	 @OneToMany(targetEntity = ConsultantInstruction.class,cascade = CascadeType.ALL)
     @JoinColumn(name = "mc_fk",referencedColumnName = "id",insertable = true, updatable = true, nullable=false)
     private List<ConsultantInstruction> consultantInstruction=new ArrayList<ConsultantInstruction>();
	 
}