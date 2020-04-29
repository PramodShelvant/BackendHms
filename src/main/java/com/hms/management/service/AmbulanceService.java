package com.hms.management.service;

import java.util.List;

import com.hms.management.model.Ambulance;

public interface AmbulanceService {

	
	public Ambulance addAmbulance(Ambulance ambulance);
	public List<Ambulance> getAll();
	public Object updateAmbulance(Ambulance ambulance);
	public Object deleteAmbulance(int id);
}
