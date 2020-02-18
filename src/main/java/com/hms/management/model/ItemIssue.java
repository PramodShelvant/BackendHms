package com.hms.management.model;

import java.util.Date;

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
@Table(name = "item_issue")

public class ItemIssue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String issueType;
	private String issueTo;
	private String issueBy;
	private String issueDate;
	private String returnDate;
	private int itemCategoryId;
	private int itemId;
	private int quantity;
	private String note;
	private int isReturned;
	private Date createdAt;
	private Date isActive;
}
