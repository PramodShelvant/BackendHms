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
@Table(name = "expense_head")
public class ExpenseHead {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String expenseHead;
	private String description;
	private String isActive;
	private String isDeleted;
	private String createdAt;
	private String updatedAt;
}
