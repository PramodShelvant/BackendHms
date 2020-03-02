package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodDonor;

public interface BloodDonorService {

	
	
	public BloodDonor addBloodDonor(BloodDonor bloodDonor);
    public BloodDonor getBloodDonor(int id) throws RecordNotFoundException;
    public List<BloodDonor> getAllBloodDonor() throws RecordNotFoundException;
	public Object deleteBloodDonor(int id);
	public Object updateBloodDonor(BloodDonor bloodDonor);

}
