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
@Table(name = "front_cms_settings")

public class FrontCmsSettings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String theme;
	private int isActiveRtl;
	private int isActiveFrontCms;
	private int isActiveSidebar;
	private String logo;
	private String contactUsEmail;
	private String complainFormEmail;
	private String sidebarOptions;
	private String fbUrl;
	private String twitterUrl;
	private String youtubeUrl;
	private String googlePlus;
	private String instagramUrl;
	private String pinterestUrl;
	private String linkedinUrl;
	private String googleAnalytics;
	private String footerText;
	private String favIcon;
	private String createdAt;
}
