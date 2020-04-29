package com.hms.management.service;

import java.util.List;

import com.hms.management.model.BloodBankStatus;

public interface BloodBankStatusService {
   
	
	
	public BloodBankStatus addBloodBankStatus(BloodBankStatus bloodBankStatus);
	public List<BloodBankStatus> getBloodBankStatus();
	public Object getByBloodGroup(String bloodGroup);
	
}
