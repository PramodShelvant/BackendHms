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
import com.hms.management.model.GenarateBills;
import com.hms.management.serviceimpl.GenarateBillServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("/generatebill")
public class GenarateBillController {

	
	@Autowired
	public GenarateBillServiceImpl genarateBillServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public GenarateBills addGenarateBill(@RequestBody GenarateBills genarateBills) throws RecordNotFoundException{
		return genarateBillServiceImpl.addGenarateBill(genarateBills);
         }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public GenarateBills getByIdGenarateBills(@PathVariable int id) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of genarate bills", genarateBillServiceImpl.getGenarateBill(id));
		return genarateBillServiceImpl.getGenarateBills(id);
    }
	
	
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<GenarateBills> getAll() throws RecordNotFoundException {
		return genarateBillServiceImpl.getAll();
		 
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteGenarateBills(@PathVariable int id) {
		return genarateBillServiceImpl.deleteGenarateBills(id);
		
	}
}
