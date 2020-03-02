package com.hms.management.service;

import java.util.List;
import java.util.Optional;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Recieption;

public interface RecieptionService {

	
	
	public Recieption addRecieption(Recieption recieption);
	public Optional<Recieption> getRecieption(int id) throws RecordNotFoundException;
    public List<Recieption> getAllRecieption() throws RecordNotFoundException;
    public String  delteRecieption(int id);
	public Object deleteRecieption(int id);
}
