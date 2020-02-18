package com.hms.management.service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.MedicianDetails;

public interface MedicianDetailsservice {

	public MedicianDetails addMedicianDetails(MedicianDetails medicianDetails);

	MedicianDetails getMedicianDetails(int mid) throws RecordNotFoundException;
}
