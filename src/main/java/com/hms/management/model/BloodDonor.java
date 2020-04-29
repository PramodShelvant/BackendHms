package com.hms.management.model;

 
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blood_donor")
public class BloodDonor{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String bloodDonorId;
	private String donorName;
 	private String age;
	private String month;
	private Date donateDate;
	private String bloodGroup;
	private String gender;
	private String address;
	private String contactNo;
	private Date createdAt;
	private Date updatedAt;
	
 
	@OneToOne
	@JoinColumn(name="InstuteId")
	@ApiModelProperty(notes = "InstuteId")
	private Institution institution;

}
