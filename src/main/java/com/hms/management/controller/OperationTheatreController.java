package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OperationTheatre;
import com.hms.management.serviceimpl.OperationTheatreServiceImpl;
@CrossOrigin()
@RestController
@RequestMapping("operationtheatre")
public class OperationTheatreController {

	
	@Autowired
	public OperationTheatreServiceImpl operationTheatreServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public OperationTheatre addOperationTheatre(@RequestBody OperationTheatre operationTheatre) throws RecordNotFoundException{
		return operationTheatreServiceImpl.addOperationTheatre(operationTheatre);
         }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public OperationTheatre getByIdOperationTheatre(@PathVariable int id) throws RecordNotFoundException {
		return operationTheatreServiceImpl.getByIdOperationTheatre(id);
    }
	
	
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<OperationTheatre> getAllOperationTheatre() throws RecordNotFoundException {
		return operationTheatreServiceImpl.getAllOperationTheatre();
		
		 
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteOperationTheatre(@PathVariable int id) {
		return operationTheatreServiceImpl.deleteOperationTheatre(id);
		
	}
	@CrossOrigin
	@RequestMapping(value = "operationtheatre/{patientId}",method = RequestMethod.GET,produces = "application/json")
	public List<OperationTheatre> getByPatientId(@PathVariable String patientId){
		return operationTheatreServiceImpl.getByPatientId(patientId);
		
	}
}







