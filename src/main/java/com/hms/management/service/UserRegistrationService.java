package com.hms.management.service;

import java.util.List;
import java.util.Map;

import com.hms.management.model.UserRegistration;

public interface UserRegistrationService {
	
	public Map<String, Object> registration(UserRegistration userRegistration);
	public Map<String, Object> userLogIn(UserRegistration userRegistration);
	public List<UserRegistration> fetchAllUser();
	public List<UserRegistration> getAllregistration(Integer pageNo, Integer pageSize, String sortBy);
	public Object deleteUserRegistration(int id);
	public UserRegistration adUserRegistration(UserRegistration userRegitration);


}
