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
@Table(name = "print_setting")

public class PrintSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String printHeader;
	private String printFooter;
	private String settingFor;
	private String isActive;
}
