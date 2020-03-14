package com.hms.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.BillSummery;
import com.hms.management.repository.BillSummeryReposotory;
import com.hms.management.service.BillSummeryService;

@Service
public class BillSummeryServiceImpl implements BillSummeryService{

	
	
	@Autowired
	public BillSummeryReposotory billSummeryRepository;

	@Override
	public BillSummery addBillSummery(BillSummery billSummery) {
 		return billSummeryRepository.save(billSummery);
	}

	@Override
	public List<BillSummery> getBillSummery(String opdId) {
 		return billSummeryRepository.findByOpdId(opdId);
	}
}
