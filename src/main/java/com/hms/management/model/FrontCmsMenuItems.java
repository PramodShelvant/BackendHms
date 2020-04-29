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
@Table(name = "front_cms_menu_items")

public class FrontCmsMenuItems {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int menuId;
	private String menu;
	private int pageId;
	private int parentId;
	private String extUrl;
	private int openNewTab;
	private String extUrlLink;
	private String slug;
	private int weight;
	private int publish;
	private String description;
	private String isActive;
	private String createdAt;
}
