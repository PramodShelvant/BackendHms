package com.hms.management.service;

import java.util.List;
import java.util.Map;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PurchaseMedician;

public interface PurchaseMedicianService {

	Map<String, Object> addPurchaseMedician(PurchaseMedician purchaseMedician) throws RecordNotFoundException ;

	PurchaseMedician getPurchaseMedician(int id) throws RecordNotFoundException;

	List<PurchaseMedician> getAllPurchaseMedician() throws RecordNotFoundException;

	Object deletePurchaseMedician(int id);

}
