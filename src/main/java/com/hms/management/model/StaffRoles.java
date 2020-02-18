package com.hms.management.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "staff_roles")

public class StaffRoles {
	@Id
	private int id;
	private int roleId;
	private int staffId;
	private int isActive;
	private String createdAt;
	private String updatedAt;
}
