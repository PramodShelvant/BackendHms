package com.hms.management.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles_permissions")

public class RolesPermissions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int roleId;
	private int permCatId;
	private int canView;
	private int canAdd;
	private int canEdit;
	private int canDelete;
	private String createdAt;
}
