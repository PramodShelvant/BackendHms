package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodIssue;

public interface BloodIssueService {
	
	public BloodIssue addBloodIssue(BloodIssue BloodIssue);

	public BloodIssue getBloodIssue(int id) throws RecordNotFoundException;

	public List<BloodIssue> getAllBloodIssue() throws RecordNotFoundException;

	public Object deleteBloodIssue(int id);

}
