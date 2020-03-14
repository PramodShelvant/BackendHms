package com.hms.management.service;

import java.util.List;

import com.hms.management.model.ScheduleList;

public interface ScheduleListService {

	
	public ScheduleList addScheduleList(ScheduleList scheduleList);
 	public Object deleteScheduleList(int id);
	public List<ScheduleList> getAllScheduleList();
	List<ScheduleList> getScheduleList(String doctorId);
}
