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
@Table(name = "PostalDisPatchList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostalDisPatchList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String toTitle;
	private String referenceNo;
	private String address;
	private String note;
	private String fromTitle;
	private String date;
	private String attachdDocument;
}
