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
@Table(name = "front_cms_pages")

public class FrontCmsPages 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String pageType;
	private int isHomepage;
	private String title;
	private String url;
	private String type;
	private String slug;
	private String metaTitle;
	private String metaDescription;
	private String metaKeyword;
	private String featureImage;
	private String description;
	private String publishDate;
	private int publish;
	private int sidebar;
	private String isActive;
	private String createdAt;
}
