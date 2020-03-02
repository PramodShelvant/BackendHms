package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodIssue;
import com.hms.management.repository.BloodIssueRepository;
import com.hms.management.service.BloodIssueService;
@Service
public class BloodIssueServiceImpl implements BloodIssueService{

	
	@Autowired
	public BloodIssueRepository bloodIssueRepository;

	@Override
	public BloodIssue addBloodIssue(BloodIssue BloodIssue) {
		Date d=new Date();
		BloodIssue.setUpdatedAt(d);
		BloodIssue.setCreatedAt(d);
 		return bloodIssueRepository.save(BloodIssue);
	}
	
	@Override
	public BloodIssue getBloodIssue(int id) throws RecordNotFoundException {
 		return bloodIssueRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no BloodIssue records for this id"));
	}

	@Override
	public List<BloodIssue> getAllBloodIssue() throws RecordNotFoundException {
 		return bloodIssueRepository.findAll();
	}

	@Override
	public Object deleteBloodIssue(int id) {
		Map<String, Object> map=new HashMap<>();
		bloodIssueRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
}
