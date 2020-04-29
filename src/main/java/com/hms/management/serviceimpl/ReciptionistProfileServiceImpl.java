package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ReciptionistProfile;
import com.hms.management.model.UserRegistration;
import com.hms.management.repository.ReciptionistProfileRepository;
import com.hms.management.repository.UserRegistrationRepository;
import com.hms.management.service.ReciptionistProfileService;

@Service
public class ReciptionistProfileServiceImpl implements ReciptionistProfileService{

	
	@Autowired
	public ReciptionistProfileRepository reciptionistProfileRepository;
	
	@Autowired
	public UserRegistrationRepository userRegistrationRepository;

	@Override
	public ReciptionistProfile getReciptionistProfile(int id) throws RecordNotFoundException {
 	   return reciptionistProfileRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No ambulance record exist for given id"));

	}

	@Override
	public Object changePassword(String oldPassword, String newPassword, String userId) {
		
		Map<String, Object> map=new HashMap<>();
		UserRegistration u=userRegistrationRepository.findByUserId(userId);
		if(u.getEmail()!=null || u.getMobileNo()!=null) {
			if(u.getPassword().equals(oldPassword)) {
				u.setPassword(newPassword);
				userRegistrationRepository.save(u);
				map.put("status", 1);
			}else {
				map.put("msg", "password not matched");
				return map;
				}
		  }
		return map;
 	}

	 
}
