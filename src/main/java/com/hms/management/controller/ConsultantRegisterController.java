package com.hms.management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ConsultantRegister;
import com.hms.management.serviceimpl.ConsultantRegisterServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("consultantregister")
public class ConsultantRegisterController {

	
	@Autowired
	public ConsultantRegisterServiceImpl consultantRegisterServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public ConsultantRegister addConsultantRegister(@RequestBody ConsultantRegister consultantRegister) {
		System.out.println(consultantRegister);
		return consultantRegisterServiceImpl.addConsultantRegister(consultantRegister);
		
	}
	
	@CrossOrigin
    @RequestMapping(value = "/{ipdId}", method = RequestMethod.GET, produces = "application/json")
	public Object getConsultantRegister(@PathVariable String ipdId) throws RecordNotFoundException {	
		List<Object> li=new ArrayList<>();
		//li.add("sdfghj");
		 consultantRegisterServiceImpl
		.getConsultantRegister(ipdId)
		.stream()
		.map(item->{	
		item.getConsultantInstruction().forEach(data->li.add(data));return 1;}).collect(Collectors.toList());
		return li;
		
		
	}
	
	
}
