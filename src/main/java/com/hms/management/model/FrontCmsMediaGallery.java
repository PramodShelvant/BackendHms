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
@Table(name = "front_cms_media_gallery")

public class FrontCmsMediaGallery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String image;
	private String thumbPath;
	private String dirPath;
	private String imgName;
	private String thumbName;
	private String createdAt;
	private String fileType;
	private String fileSize;
	private String vidUrl;
	private String vidTitle;
}
