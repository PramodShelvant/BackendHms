package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PostalRecieveList;
import com.hms.management.repository.PostalRecieveListRepository;
import com.hms.management.service.PostalRecieveListService;

@Service
public class PostalRecieveListServiceImpl implements PostalRecieveListService{

	
	@Autowired
	public PostalRecieveListRepository postalRecieveListRepository;

	@Override
	public PostalRecieveList addPostalRecieveList(PostalRecieveList postalRecieveList) {
 		return postalRecieveListRepository.save(postalRecieveList);
	}

	@Override
	public PostalRecieveList getpostalRecieveList(int id) throws RecordNotFoundException {
 		Optional<PostalRecieveList> v=postalRecieveListRepository.findById(id);
		if(v.isPresent()) {
		   return v.get();
     } else {
        throw new RecordNotFoundException("No PostalRecieveList record exist for given id");
    }
 }

	@Override
	public List<PostalRecieveList> getAllpostalRecieveList() throws RecordNotFoundException {
 		return postalRecieveListRepository.findAll();
	}

	@Override
	public Object deletePostalRecieveList(int id) {
		Map<String, Object> map=new HashMap<>();
		postalRecieveListRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

	
	@Override
	public PostalRecieveList adPostalRecieveList(PostalRecieveList postalRecieveList) {
 		return postalRecieveListRepository.save(postalRecieveList);
	}
}
