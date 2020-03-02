package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.GenarateBills;

public interface GenarateBillService {

	
	public GenarateBills addGenarateBill(GenarateBills genarateBills) throws RecordNotFoundException;
    public List<GenarateBills> getAll() throws RecordNotFoundException;
	public GenarateBills getGenarateBills(int id) throws RecordNotFoundException;
	public Object deleteGenarateBills(int id);

}
