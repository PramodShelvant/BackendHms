package com.hms.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.Staff;
import com.hms.management.repository.StaffRepository;
import com.hms.management.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{

	
	@Autowired
	public StaffRepository staffRepository;

	@Override
	public Object addStaff(Staff n) {
 		return staffRepository.save(n);
	}

	@Override
	public Staff addStaffs(Staff staff) {
 		return staffRepository.save(staff);
	}

	@Override
	public Object getByStaffId(String staffId) {
 		return staffRepository.findByStaffId(staffId);
	}

	@Override
	public List<Staff> getAllStaff() {
 		return staffRepository.findAll();
	}
}
