package com.hms.management.service;

import java.util.List;

import com.hms.management.model.PharmacyBillBasic;

public interface PharmacyBillBasicService {

	
	public PharmacyBillBasic addPharmacyBillBasic(PharmacyBillBasic pharmacyBillBasic);
	public List<PharmacyBillBasic> getAllPharmacyBillBasic();
	public Object getByPatientId(String patientId);
	
}
