package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OperationTheatre;
import com.hms.management.repository.OperationTheatreRepository;
import com.hms.management.service.OperationTheatreService;

@Service
public class OperationTheatreServiceImpl implements OperationTheatreService {

	
	@Autowired
	public OperationTheatreRepository operationTheatreRepository;

	@Override
	public OperationTheatre addOperationTheatre(OperationTheatre operationTheatre) {
		Date d=new Date();
		operationTheatre.setCreatedAt(d);
		operationTheatre.setUpdatedAt(d);
 		return operationTheatreRepository.save(operationTheatre);
	}

	@Override
	public OperationTheatre getByIdOperationTheatre(int id) throws RecordNotFoundException {
 		return operationTheatreRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No OperationTheatre record exist for given id"));

	}

	@Override
	public List<OperationTheatre> getAllOperationTheatre() {
 		return operationTheatreRepository.findAll();
	}
}
