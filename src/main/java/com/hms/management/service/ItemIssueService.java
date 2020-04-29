package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ItemIssue;

public interface ItemIssueService {

	
	public ItemIssue addItemIssue(ItemIssue itemIssue) throws RecordNotFoundException;
	public ItemIssue getItemIssueById(int id) throws RecordNotFoundException;
	public List<ItemIssue> getAllItemIssue() throws RecordNotFoundException;
	public Object deleteItemIssue(int id);

}
