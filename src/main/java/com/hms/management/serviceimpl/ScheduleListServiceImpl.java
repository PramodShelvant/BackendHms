package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.ScheduleList;
import com.hms.management.repository.ScheduleListRepository;
import com.hms.management.service.ScheduleListService;

@Service
public class ScheduleListServiceImpl implements ScheduleListService{
    
	
	@Autowired
	public ScheduleListRepository scheduleListRepository;

	
	@Override
	public ScheduleList addScheduleList(ScheduleList scheduleList) {
 		return scheduleListRepository.save(scheduleList);
	}


	@Override
	public List<ScheduleList> getScheduleList(String doctorId) {
 		return scheduleListRepository.findByDoctorId(doctorId);
	}


	@Override
	public Object deleteScheduleList(int id) {
		Map<String, Object> map=new HashMap<>();
		scheduleListRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}


	@Override
	public List<ScheduleList> getAllScheduleList() {
 		return scheduleListRepository.findAll();
	} 
}
