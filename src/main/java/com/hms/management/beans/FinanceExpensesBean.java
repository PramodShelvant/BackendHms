package com.hms.management.beans;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FinanceExpensesBean {
  	private int id;
	private int expHeadId;
	private String name;
	private String invoiceNo;
	private String date;
	private float amount;
	private MultipartFile documents;
	private String note;
	private String isActive;
	private String isDeleted;
	private Date createdAt;
	private Date updatedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExpHeadId() {
		return expHeadId;
	}
	public void setExpHeadId(int expHeadId) {
		this.expHeadId = expHeadId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public MultipartFile getDocuments() {
		return documents;
	}
	public void setDocuments(MultipartFile documents) {
		this.documents = documents;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
