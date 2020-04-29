package com.hms.management.service;

import java.util.List;

import com.hms.management.model.BillSummery;

public interface BillSummeryService {

	
	public BillSummery addBillSummery(BillSummery billSummery);
	public List<BillSummery> getBillSummery(String opdId);
}
