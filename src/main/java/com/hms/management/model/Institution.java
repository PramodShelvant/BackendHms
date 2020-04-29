package com.hms.management.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Institution")
public class Institution {

	
	//@Id @GeneratedValue(generator="system-uuid")
	//@GenericGenerator(name="system-uuid", strategy = "uuid") 
	@Id
 	private String InstuteId;
	private String lot;
	private String bagNo;
	private String quantity;
	private Date donatedDate;
	private String action;
	private Date createdAt;
	private Date updatedAt;
}
