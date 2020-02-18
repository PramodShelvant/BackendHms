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
@Table(name = "email_config")

public class EmailConfig 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailType;
	private String smtpServer;
	private String smtpPort;
	private String smtpUsername;
	private String smtpPassword;
	private String sslTls;
	private String isActive;
	private String createdAt;
}
