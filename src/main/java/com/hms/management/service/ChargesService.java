package com.hms.management.service;

import java.util.List;

import com.hms.management.model.Charges;

public interface ChargesService {

	
	public Charges addCharges(Charges charges);

	public Object getCharges(String opdId);

	public List<Charges> getAll();
}
