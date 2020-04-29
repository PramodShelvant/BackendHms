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
import com.hms.management.model.ConsultantRegisterForOt;
import com.hms.management.serviceimpl.ConsultantRegisterForOtServiceImpl;

@RestController
@RequestMapping("consultantregisterforot")
public class ConsultantRegisterForOtController {

	
	@Autowired
	public ConsultantRegisterForOtServiceImpl consultantRegisterForOtServiceImpl;
	
	
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public ConsultantRegisterForOt addConsultantRegisterForOt(@RequestBody ConsultantRegisterForOt consultantRegisterForOt) {
		return consultantRegisterForOtServiceImpl.addConsultantRegisterForOt(consultantRegisterForOt);
		
	}
	@CrossOrigin
    @RequestMapping(value = "/{patientId}", method = RequestMethod.GET, produces = "application/json")
	public Object getConsultantRegister(@PathVariable String patientId) throws RecordNotFoundException {	
		List<Object> li=new ArrayList<>();
 		consultantRegisterForOtServiceImpl
		.getConsultantRegisterForOt(patientId)
		.stream()
		.map(item->{	
		item.getConsultantInstructionForOt().forEach(data->li.add(data));return 1;}).collect(Collectors.toList());
		return li;
		
		
	}
}
