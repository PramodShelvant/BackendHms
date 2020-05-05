package com.hms.management.Finance.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Table
@Entity
public class FinanceIncomeHead {
	
	@Id
	@GeneratedValue
	private int id;
	private int incomeHeadId;
	  private String name;
	  private String invoiceNumber;
	  @Temporal(TemporalType.TIMESTAMP)
	  private Date date;
	  private String amount;
	  private String attachDocument;
	  private String description;
	  
	public FinanceIncomeHead() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinanceIncomeHead(int id, int incomeHeadId, String name, String invoiceNumber, Date date, String amount,
			String attachDocument, String description) {
		super();
		this.id = id;
		this.incomeHeadId = incomeHeadId;
		this.name = name;
		this.invoiceNumber = invoiceNumber;
		this.date = date;
		this.amount = amount;
		this.attachDocument = attachDocument;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIncomeHeadId() {
		return incomeHeadId;
	}
	public void setIncomeHeadId(int incomeHeadId) {
		this.incomeHeadId = incomeHeadId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAttachDocument() {
		return attachDocument;
	}
	public void setAttachDocument(String attachDocument) {
		this.attachDocument = attachDocument;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
}
