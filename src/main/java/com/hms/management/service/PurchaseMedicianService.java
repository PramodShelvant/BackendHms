package com.hms.management.service;

import java.util.List;
import java.util.Map;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PurchaseMedician;

public interface PurchaseMedicianService {

	public Map<String, Object> addPurchaseMedician(PurchaseMedician purchaseMedician) throws RecordNotFoundException ;

	public PurchaseMedician getPurchaseMedician(int id) throws RecordNotFoundException;

	public List<PurchaseMedician> getAllPurchaseMedician() throws RecordNotFoundException;

	public Object deletePurchaseMedician(int id);

	public PurchaseMedician adPurchaseMedician(PurchaseMedician purchaseMedician);

}
