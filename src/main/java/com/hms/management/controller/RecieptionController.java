package com.hms.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Recieption;
import com.hms.management.serviceimpl.RecieptionServiceImpl;

@CrossOrigin()
@Controller
@RequestMapping("/recieption")
public class RecieptionController {

	
	
	@Autowired
	public  RecieptionServiceImpl recieptionServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public Recieption addRecieption(@RequestBody Recieption recieption) {
		return recieptionServiceImpl.addRecieption(recieption);
		
         }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<Recieption> getByIdRecieption(@PathVariable int id) throws RecordNotFoundException {
		return recieptionServiceImpl.getRecieption(id);
	 
    }
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<Recieption> getAll() throws RecordNotFoundException {
		return recieptionServiceImpl.getAllRecieption();
		 
    }
	@CrossOrigin
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteRecieptionist(@PathVariable int id) {
		return recieptionServiceImpl.delteRecieption(id);
		
	}
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteRecieption(@PathVariable int id) {
		return recieptionServiceImpl.deleteRecieption(id);
		
	}
}
