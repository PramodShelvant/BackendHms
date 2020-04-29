package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.VisitorList;
 
public interface VisitorListService {
	public Object addVisitors(VisitorList visitorList) throws RecordNotFoundException;
    public VisitorList getVisitorList(int id) throws RecordNotFoundException;
    public List<VisitorList> getAllVisitorList();
	public Object deleteVisitorList(int id);
	public VisitorList adVisitorList(VisitorList visitorList);



}
