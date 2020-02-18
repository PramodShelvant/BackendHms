package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ItemIssue;
import com.hms.management.repository.ItemIssueRepository;
import com.hms.management.service.ItemIssueService;
@Service
public class ItemIssueServiceImpl implements ItemIssueService {

	
	@Autowired
	public ItemIssueRepository itemIssueRepository;

	@Override
	public ItemIssue addItemIssue(ItemIssue itemIssue) {
       Date d=new Date();
       itemIssue.setCreatedAt(d);
       itemIssue.setIsActive(d);
    return itemIssueRepository.save(itemIssue);
	}
	public ItemIssue getItemIssueById(int id) throws RecordNotFoundException {
		return itemIssueRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No ItemIssue record exist for given id"));
		 	}
	
	@Override
	public List<ItemIssue> getAllItemIssue() throws RecordNotFoundException {
  	 		return itemIssueRepository.findAll();
		
	}
}
