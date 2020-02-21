package com.hms.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Recieption;
import com.hms.management.repository.RecieptionRepository;
import com.hms.management.service.RecieptionService;

@Service
public class RecieptionServiceImpl implements RecieptionService{

	
	
	
	@Autowired
	public RecieptionRepository recieptionrepository;
	@Override
	public Recieption addRecieption(Recieption recieption) {
 		return recieptionrepository.save(recieption);
	}

	@Override
	public Optional<Recieption> getRecieption(int id) throws RecordNotFoundException {
 		return recieptionrepository.findById(id);
	}

	@Override
	public List<Recieption> getAllRecieption() throws RecordNotFoundException {
 		return recieptionrepository.findAll();
	}

	@Override
	public String delteRecieption(int id) {
		
		return null;
 		
	}

}
