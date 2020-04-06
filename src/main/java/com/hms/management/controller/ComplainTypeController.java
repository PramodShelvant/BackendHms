package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.ComplainTypeBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ComplainType;
import com.hms.management.serviceimpl.ComplainTypeServiceImpl;

@CrossOrigin()
@RestController
@RequestMapping("complaintype")
public class ComplainTypeController {

	
	
	
	private static String UPLOADED_FOLDER = "uploads/";

	@Autowired
	public ComplainTypeServiceImpl complainTypeServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public Object addBirthRecord(ComplainTypeBean complainTypeBean) throws RecordNotFoundException {
		System.out.println("jjjjjjjjjjj"+complainTypeBean.toString());
		//Map<String,Object> map=new HashMap<String, Object>();
		ComplainType n=new ComplainType();
		System.out.println(n.toString());
        byte[] bytes = null;
		try {
			bytes = complainTypeBean.getAttachedDocument().getBytes();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + complainTypeBean.getAttachedDocument().getOriginalFilename());
           try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setAttachedDocument(UPLOADED_FOLDER + complainTypeBean.getAttachedDocument().getOriginalFilename());
        n.setComplainBy(complainTypeBean.getComplainBy());
        n.setSource(complainTypeBean.getSource());
        n.setPhone(complainTypeBean.getPhone());
        n.setDate(complainTypeBean.getDate());
        n.setDescription(complainTypeBean.getDescription());
        n.setAssigned(complainTypeBean.getAssigned());
        n.setNote(complainTypeBean.getNote());
        n.setId(complainTypeBean.getId());
		return complainTypeServiceImpl.addComplainType(n);
	}

	@CrossOrigin
    @RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<ComplainType> getComplainTypeAll() throws RecordNotFoundException {
		 return complainTypeServiceImpl.getAllComplainType();
    }
	@CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ComplainType getComplainTypeAll(@PathVariable int id) throws RecordNotFoundException {
		 return complainTypeServiceImpl.getComplainType(id);
    }
	@CrossOrigin
  	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  	public Object deleteComplainType(@PathVariable int id) {
         return complainTypeServiceImpl.deleteComplainType(id);
  		
  	}	
	
	
	@CrossOrigin
	@RequestMapping(value = "/iffileisnull",method = RequestMethod.POST,produces = "application/json")
	public ComplainType addComplainType(@RequestBody ComplainType complainType) {
		return complainTypeServiceImpl.adComplainType(complainType);
		
	}
}
