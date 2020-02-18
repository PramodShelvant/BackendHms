package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodIssue;

public interface BloodIssueService {
	
	public BloodIssue addBloodIssue(BloodIssue BloodIssue);

	BloodIssue getBloodIssue(int id) throws RecordNotFoundException;

	List<BloodIssue> getAllBloodIssue() throws RecordNotFoundException;

}
