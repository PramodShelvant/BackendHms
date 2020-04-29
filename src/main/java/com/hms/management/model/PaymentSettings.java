package com.hms.management.model;

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
@Table(name = "payment_settings")

public class PaymentSettings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String paymentType;
	private String apiUsername;
	private String apiSecretKey;
	private String salt;
	private String apiPublishableKey;
	private String apiPassword;
	private String apiSignature;
	private String apiEmail;
	private String paypalDemo;
	private String accountNo;
	private String isActive;
	private String createdAt;
	private String updatedAt;
}
