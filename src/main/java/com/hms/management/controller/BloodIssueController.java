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
	
	@CrossOrigin
	@RequestMapping(value = "/{doctor}",method = RequestMethod.GET,produces = "application/json")
	public Object GetByDoctorName(@PathVariable String doctor) {
		return bloodIssueServiceImpl
		.GetByDoctorName(doctor);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "{donorName}",method = RequestMethod.GET,produces = "application/json")
	public Object getByDonorName(@PathVariable String donorName) {
		return bloodIssueServiceImpl
		.getByDonorName(donorName);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/currentmonthreport",method = RequestMethod.GET)
	public Object getCurrentMonthReport() {
		return bloodIssueServiceImpl.getCurrentMonthReposrt();
		
	}
	@CrossOrigin
	@RequestMapping(value = "/currentyearreport",method = RequestMethod.GET)
	public Object getCurrentYearRport() {
		return bloodIssueServiceImpl.getCurrentYearReposrt();
		
	}

	
	@CrossOrigin
	@RequestMapping(value = "/lastsevendaysreport",method = RequestMethod.GET)
	public Object getLastSevenDaysRecord() {
		return bloodIssueServiceImpl.getLastSevenDaysReport();
   }
	
	@CrossOrigin
	@RequestMapping(value = "/lastthreemontsreports",method = RequestMethod.GET)
	public Object getLastThreeMonthReports() {
		return bloodIssueServiceImpl.getLastThreeMonthsReports();
   }

	@CrossOrigin
	@RequestMapping(value = "/lastsixmonthreports",method = RequestMethod.GET)
	public Object getLastSixMonthReports() {
		return bloodIssueServiceImpl.getLastSixMonthReports();
   }
	
	@CrossOrigin
	@RequestMapping(value = "/lastninemonthsrepots",method = RequestMethod.GET)
	public Object getLastNineMonthsReports() {
		return bloodIssueServiceImpl.getLastNineMonthsReports();
   }
	
	@CrossOrigin
	@RequestMapping(value = "/lasttwelvemonthsreports",method = RequestMethod.GET)
	public Object getLastTwelveMonthsReports() {
		return bloodIssueServiceImpl.getLateTwelveMonthsReports();
   }
	@CrossOrigin
	@RequestMapping(value = "/lastmonth",method = RequestMethod.GET)
	public Object getLastMonth() {
		return bloodIssueServiceImpl.getlastMont();
   }

}
