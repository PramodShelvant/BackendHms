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
@Table(name = "front_cms_page_contents")

public class FrontCmsPageContents {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int pageId;
	private String contentType;
	private String createdAt;
}
