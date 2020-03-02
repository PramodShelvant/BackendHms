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
import com.hms.management.model.BloodIssue;
import com.hms.management.serviceimpl.BloodIssueServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("bloodissue")
public class BloodIssueController {

	
	@Autowired
	public BloodIssueServiceImpl bloodIssueServiceImpl;
	
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public BloodIssue addBloodIssue(@RequestBody BloodIssue BloodIssue) throws RecordNotFoundException{
	//	Map<String, Object> map=new HashMap<String, Object>();
		//BloodIssue updated = bloodIssueServiceImpl.addBloodIssue(BloodIssue);
     //  map.put("data saved", new ResponseEntity<BloodIssue>(updated, new HttpHeaders(), HttpStatus.OK));
       return bloodIssueServiceImpl.addBloodIssue(BloodIssue);
       }
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public BloodIssue getBloodDonorissueById(@PathVariable int id) throws RecordNotFoundException {
 		return bloodIssueServiceImpl.getBloodIssue(id);
    }
	@CrossOrigin
    @RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<BloodIssue> getAllBloodDonorissue() throws RecordNotFoundException {
 		return bloodIssueServiceImpl.getAllBloodIssue();
    }
	
	@CrossOrigin
  	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  	public Object deleteBloodIssue(@PathVariable int id) {
         return bloodIssueServiceImpl.deleteBloodIssue(id);
  		
  	}	
}
