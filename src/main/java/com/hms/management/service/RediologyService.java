package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Rediology;

public interface RediologyService {

	
	public Rediology addRediology(Rediology rediology) throws RecordNotFoundException;

	Rediology getRediology(int id) throws RecordNotFoundException;
    List<Rediology> getAllRediology() throws RecordNotFoundException;

 
}
