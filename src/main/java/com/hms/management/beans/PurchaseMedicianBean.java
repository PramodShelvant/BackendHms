package com.hms.management.beans;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseMedicianBean {
 
  		private int id;
		private String medicianCategory;
		private String medicianName;
		private int batchNo;
		private String expireDate;
		private float MRP;
		private float batchAmount;
		private float salePrice;
		private String packagingQty;
		private String quentity;
		private String packagingPrice;
		private float amount;
		private float total;
		private float discount;
		private float tax;
		private float netAmount;
		private String note;
		private MultipartFile attachDocument;

}
