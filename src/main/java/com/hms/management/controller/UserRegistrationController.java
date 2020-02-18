package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.UserRegistrationBean;
import com.hms.management.model.UserRegistration;
import com.hms.management.serviceimpl.UserRegistrationServiceImpl;
@CrossOrigin()
@RestController
public class UserRegistrationController {


	
	
	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//SPRING//";

	
	@Autowired
	public UserRegistrationServiceImpl userRegistrationServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value="register", method = RequestMethod.POST)
    public Map<String, Object> registration(UserRegistrationBean userRegistrationBean){
		Map<String, Object> response=new HashMap<String, Object>();
		UserRegistration n=new UserRegistration();
		if(userRegistrationBean.getUserProfile()!=null) {
	        byte[] bytes = null;
			try {
				bytes = userRegistrationBean.getUserProfile().getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
	        Path path = Paths.get(UPLOADED_FOLDER + userRegistrationBean.getUserProfile().getOriginalFilename());
	        try {
				Files.write(path, bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        n.setUserProfile(UPLOADED_FOLDER + userRegistrationBean.getUserProfile().getOriginalFilename());
			 n.setEmail(userRegistrationBean.getEmail());
			 n.setMobileNo(userRegistrationBean.getMobileNo());
			 n.setName(userRegistrationBean.getName());
			 n.setRole(userRegistrationBean.getRole());
			 n.setPassword(userRegistrationBean.getPassword());
			 n.setSignupDate(userRegistrationBean.getSignupDate());
		 	// response.put("msg",userRegistrationServiceImpl.registration(n));

			}else {
				 n.setEmail(userRegistrationBean.getEmail());
				 n.setMobileNo(userRegistrationBean.getMobileNo());
				 n.setName(userRegistrationBean.getName());
				 n.setRole(userRegistrationBean.getRole());
				 n.setPassword(userRegistrationBean.getPassword());
				 n.setSignupDate(userRegistrationBean.getSignupDate());
			 	 response.put("msg",userRegistrationServiceImpl.registration(n));

				 }
 
 		response.put("msg",userRegistrationServiceImpl.registration(n));
 		return response;
	}
	@CrossOrigin
	@RequestMapping(value="login", method = RequestMethod.POST, produces = "application/json")
    public Map<String, Object> logIn(@RequestBody UserRegistration userRegistration){
		Map<String, Object> response=new HashMap<String, Object>();
 		response.put("msg",userRegistrationServiceImpl.userLogIn(userRegistration));
 		return response;
	}
	@CrossOrigin
	@RequestMapping(value="/fetchalluser", method = RequestMethod.GET, produces = "application/json")
    public List<UserRegistration> getAllUser(){
		//Map<String, Object> response=new HashMap<String, Object>();
 		//response.put("msg",userRegistrationServiceImpl.userLogIn(userRegistration));
 		return userRegistrationServiceImpl.fetchAllUser();
	}
	
	 
	 
	/*
	 * @RequestMapping(value="/getallregistration", method = RequestMethod.GET,
	 * produces = "application/json") public ResponseEntity<List<UserRegistration>>
	 * getAllEmployees(
	 * 
	 * @RequestParam(defaultValue = "0") Integer pageNo,
	 * 
	 * @RequestParam(defaultValue = "10") Integer pageSize,
	 * 
	 * @RequestParam(defaultValue = "id") String sortBy) { List<UserRegistration>
	 * list = userRegistrationServiceImpl.getAllregistration(pageNo, pageSize,
	 * sortBy);
	 * 
	 * return new ResponseEntity<List<UserRegistration>>(list, new HttpHeaders(),
	 * HttpStatus.OK);
	 * 
	 * }
	 */
}
