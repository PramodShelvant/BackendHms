package com.hms.management.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hms.management.model.MedicineBatchDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PurchaseMedicine {
 	private int id;
	private String supplierId;
	private String date;
	private String note;
	private float discount;
	private float tax;
	private float netamount;
	private MultipartFile attachDocument;
	private float total;
    private String medicine;

}