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
@Table(name = "front_cms_programs")

public class FrontCmsPrograms {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;
	private String slug;
	private String url;
	private String title;
	private String date;
	private String eventStart;
	private String eventEnd;
	private String eventVenue;
	private String description;
	private String isActive;
	private String createdAt;
	private String metaTitle;
	private String metaDescription;
	private String metaKeyword;
	private String featureImage;
	private String publishDate;
	private String publish;
	private int sidebar;
}
