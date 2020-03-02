package com.hms.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.TpaManagement;
import com.hms.management.serviceimpl.TpaManagementServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/tpamanagement")
public class TpaManagementController {

	
	@Autowired
	public TpaManagementServiceImpl  tpaManagementServiceImpl;
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public Map<String, Object> addPythology(@RequestBody TpaManagement tpaManagement) throws RecordNotFoundException{
		Map<String, Object> map=new HashMap<String, Object>();
		TpaManagement updated = tpaManagementServiceImpl.addTpaManagement(tpaManagement);
       map.put("data saved", new ResponseEntity<TpaManagement>(updated, new HttpHeaders(), HttpStatus.OK));
       return map;
       }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public TpaManagement getTpaManagementById(@PathVariable int id) throws RecordNotFoundException {
 		return tpaManagementServiceImpl.getTpaManagement(id);
    }
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<TpaManagement> getAllTpaManagement() throws RecordNotFoundException {
 		return tpaManagementServiceImpl.getAllTpaManagement();
	}
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteTpaManagement(@PathVariable int id) {
		return tpaManagementServiceImpl.deleteTpaManagement(id);
		
	}
}
