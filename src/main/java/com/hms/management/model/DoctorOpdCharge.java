package com.hms.management.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	private String doctorId;
	private float standardCharge;
	@Transient
	private List<OrganisationsCharges> tpaCharges;

}
