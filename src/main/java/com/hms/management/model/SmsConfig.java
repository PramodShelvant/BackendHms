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
@Table(name = "sms_config")

public class SmsConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;
	private String name;
	private String apiId;
	private String authkey;
	private String senderid;
	private String contact;
	private String username;
	private String url;
	private String password;
	private String isActive;
	private String createdAt;
	private String updatedAt;
}
