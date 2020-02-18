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
@Table(name = "sch_settings")

public class SchSettings {
	@Id
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private int langId;
	private String diseCode;
	private String dateFormat;
	private String timeFormat;
	private String currency;
	private String currencySymbol;
	private String isRtl;
	private String timezone;
	private int sessionId;
	private String startMonth;
	private String image;
	private String miniLogo;
	private String theme;
	private String creditLimit;
	private String opdRecordMonth;
	private String isActive;
	private String createdAt;
	private String updatedAt;
	private String cronSecretKey;
	private int feeDueDays;
	private String classTeacher;
}
