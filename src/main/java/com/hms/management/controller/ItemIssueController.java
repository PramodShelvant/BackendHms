package com.hms.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ItemIssue;
import com.hms.management.serviceimpl.ItemIssueServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("itemissue")
public class ItemIssueController {

	
	@Autowired
	public ItemIssueServiceImpl itemIssueServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public ItemIssue addItemIssue(@RequestBody ItemIssue itemIssue) throws RecordNotFoundException{
 		return itemIssueServiceImpl.addItemIssue(itemIssue);
	}
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ItemIssue getItemIssue(@RequestBody int id) throws RecordNotFoundException{
 		return itemIssueServiceImpl.getItemIssueById(id);
	}
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
	public List<ItemIssue> getItemIssue() throws RecordNotFoundException{
 		return itemIssueServiceImpl.getAllItemIssue();
	}
	
	 @CrossOrigin
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
		public Object deleteItemIssue(@PathVariable int id) {
			return itemIssueServiceImpl.deleteItemIssue(id);
			
		}
}
