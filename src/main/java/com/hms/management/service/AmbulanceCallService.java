package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.AmbulanceCall;

public interface AmbulanceCallService {
	
	public AmbulanceCall addAmbulanceCall(AmbulanceCall ambulanceCall);
    public List<AmbulanceCall> getAllAmbulanve() throws RecordNotFoundException;
	public AmbulanceCall getAmbulanceCall(int id) throws RecordNotFoundException;
	public Object deleteAmbulanceCall(int id);
	public Object updateAmbulance(AmbulanceCall ambulanceCall);


}
