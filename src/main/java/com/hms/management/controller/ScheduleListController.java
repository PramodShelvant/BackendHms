package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.ScheduleList;
import com.hms.management.serviceimpl.ScheduleListServiceImpl;
@CrossOrigin()
@RestController
@RequestMapping("schedulelist")
public class ScheduleListController {

	
	@Autowired
	public ScheduleListServiceImpl scheduleListServiceImpl;
	
	
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ScheduleList addScheduleList(@RequestBody ScheduleList scheduleList) {
		return scheduleListServiceImpl.addScheduleList(scheduleList);
		
	}
	@CrossOrigin
	@RequestMapping(value = "/{doctorId}", method = RequestMethod.GET, produces = "application/json")
    public List<ScheduleList> getScheduleList(@PathVariable String doctorId) {
		return scheduleListServiceImpl.getScheduleList(doctorId);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteScheduleList(@PathVariable int id) {
		return scheduleListServiceImpl.deleteScheduleList(id);
		
	}
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public List<ScheduleList> getAllScheduleList(){
		return scheduleListServiceImpl.getAllScheduleList();
	}
}
