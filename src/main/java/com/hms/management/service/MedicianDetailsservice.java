package com.hms.management.service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.MedicianDetails;

public interface MedicianDetailsservice {

	public MedicianDetails addMedicianDetails(MedicianDetails medicianDetails);

	public MedicianDetails getMedicianDetails(int mid) throws RecordNotFoundException;

	public Object deleteMedicianDetails(int id);
}
