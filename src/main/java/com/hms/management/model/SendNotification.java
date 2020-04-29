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
@Table(name = "send_notification")

public class SendNotification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String publishDate;
	private String date;
	private String message;
	private String visibleStudent;
	private String visibleStaff;
	private String visibleParent;
	private String createdBy;
	private int createdId;
	private String isActive;
	private Date createdAt;
	private Date updatedAt;
}
