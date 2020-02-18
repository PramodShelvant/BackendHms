package com.hms.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.VisitorList;
import com.hms.management.repository.VisitorListRepository;
import com.hms.management.service.VisitorListService;
@Service
public class VisitorListServiceImpl implements VisitorListService{

	
	@Autowired
	public VisitorListRepository visitorListRepository;

	@Override
	public Object addVisitors(VisitorList visitorList) throws RecordNotFoundException {
         return visitorListRepository.save(visitorList);
 	    
	}

	@Override
	public VisitorList getVisitorList(int id) throws RecordNotFoundException {
 		Optional<VisitorList> v=visitorListRepository.findById(id);
		if(v.isPresent()) {
			return v.get();
     } else {
        throw new RecordNotFoundException("No VisitorList record exist for given id");
    }
 	}

	public List<VisitorList> getAllVisitorList() {
 		return visitorListRepository.findAll();
	}
}
