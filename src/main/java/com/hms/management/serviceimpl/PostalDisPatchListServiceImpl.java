package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PostalDisPatchList;
import com.hms.management.repository.PostalDisPatchListRepository;
import com.hms.management.service.PostalDisPatchListService;

@Service
public class PostalDisPatchListServiceImpl implements PostalDisPatchListService{

	
	@Autowired
	public PostalDisPatchListRepository postalDisPatchListRepository;

	@Override
	public PostalDisPatchList addPostDisList(PostalDisPatchList postalDisPatchList) throws RecordNotFoundException {
 		return postalDisPatchListRepository.save(postalDisPatchList);
	}

	@Override
	public PostalDisPatchList getPostDisList(int id) throws RecordNotFoundException {
 		Optional<PostalDisPatchList> p=postalDisPatchListRepository.findById(id);
		if(p.isPresent()) {
            return p.get();
     } else {
        throw new RecordNotFoundException("No PostalDisPatchList record exist for given id");
    }
 }

	public List<PostalDisPatchList> getAllPostDisList() throws RecordNotFoundException {
		 return postalDisPatchListRepository.findAll();
	}

	@Override
	public Object deletePostalDisPatchList(int id) {
		Map<String, Object> map=new HashMap<>();
		postalDisPatchListRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
    @Override
	public PostalDisPatchList addpostalDisPatchListServiceImpl(PostalDisPatchList postalDisPatchList) {
 		return postalDisPatchListRepository.save(postalDisPatchList);
	}
}
