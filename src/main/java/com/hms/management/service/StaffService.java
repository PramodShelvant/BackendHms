package com.hms.management.service;

import java.util.List;

import com.hms.management.model.Staff;

public interface StaffService {

	public Object addStaff(Staff n);
	public Staff addStaffs(Staff staff);
	public Object  getByStaffId(String staffId);
	public List<Staff> getAllStaff();

}
