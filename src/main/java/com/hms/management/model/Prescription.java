package com.hms.management.model;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "prescription")
public class Prescription {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private int id;
	private String opdId;
	private String header;
	private String footer;
	private Date date;
 	
    @OneToMany(targetEntity = CaseHistory.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pr_fk",referencedColumnName = "id",insertable = true, updatable = true, nullable=false)
    private List<CaseHistory> caseHistory=new ArrayList<CaseHistory>();

	 
}
