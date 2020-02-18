package com.hms.management.service;

import java.util.List;
import java.util.Map;

import com.hms.management.model.UserRegistration;

public interface UserRegistrationService {
	
	public Map<String, Object> registration(UserRegistration userRegistration);
	public Map<String, Object> userLogIn(UserRegistration userRegistration);
	List<UserRegistration> fetchAllUser();
	List<UserRegistration> getAllregistration(Integer pageNo, Integer pageSize, String sortBy);


}
