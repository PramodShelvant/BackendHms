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
@Table(name = "front_cms_menus")

public class FrontCmsMenus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String menu;
	private String slug;
	private String description;
	private int opeNewTab;
	private String extUrl;
	private String extUrlLink;
	private int publish;
	private String contentType;
	private String isActive;
	private String created_at;
}
