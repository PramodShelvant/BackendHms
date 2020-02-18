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
@Table(name = "userlog")

public class Userlog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String user;
	private String role;
	private String ipaddress;
	private String userAgent;
	private String loginDatetime;
}
