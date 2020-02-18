package com.hms.management.controller;

import java.util.List;

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
import com.hms.management.model.AmbulanceCall;
import com.hms.management.serviceimpl.AmbulanceCallServiceImpl;

import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping("/ambulance")
public class AmbulanceCallController {

	
	@Autowired
	public AmbulanceCallServiceImpl ambulanceCallServiceImpl;
	 
    
	@CrossOrigin
 	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public AmbulanceCall addAmbulanceCall(@RequestBody AmbulanceCall ambulanceCall) throws RecordNotFoundException{
 		 return ambulanceCallServiceImpl.addAmbulanceCall(ambulanceCall);
        }
	
	 @ApiOperation(value = "get ambulance")
     @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AmbulanceCall> getAmbulanceCallById(@PathVariable int id) throws RecordNotFoundException {
		 return new ResponseEntity<AmbulanceCall>(ambulanceCallServiceImpl.getAmbulanceCall(id), new HttpHeaders(), HttpStatus.OK); 
 
    }
	@CrossOrigin
    @RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<AmbulanceCall> getAmbulanceAll() throws RecordNotFoundException {
		 return ambulanceCallServiceImpl.getAllAmbulanve(); 
    }
}
