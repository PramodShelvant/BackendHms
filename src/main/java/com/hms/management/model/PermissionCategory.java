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
@Table(name = "permission_category")

public class PermissionCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int permGroupId;
	private String name;
	private String shortCode;
	private int enableView;
	private int enableAdd;
	private int enableEdit;
	private int enableDelete;
	private String createdAt;
}
