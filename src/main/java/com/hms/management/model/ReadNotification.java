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
@Table(name = "read_notification")

public class ReadNotification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int studentId;
	private int parentId;
	private int staffId;
	private int notificationId;
	private String isActive;
	private String createdAt;
	private String updatedAt;
}
