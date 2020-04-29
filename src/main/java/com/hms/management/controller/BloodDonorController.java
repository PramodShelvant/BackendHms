package com.hms.management.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodDonor;
import com.hms.management.serviceimpl.BloodDonorServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("blooddonor")
public class BloodDonorController {

	
	@Autowired
	public BloodDonorServiceImpl bloodDonorServiceImpl;
	
	
	/*
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = "/", method = RequestMethod.POST, produces =
	 * "application/json") public BloodDonor addBloodDonor(@RequestBody BloodDonor
	 * bloodDonor) throws RecordNotFoundException{ //Map<String, Object> map=new
	 * HashMap<String, Object>(); //BloodDonor updated =
	 * bloodDonorServiceImpl.addBloodDonor(bloodDonor); // map.put("data saved", new
	 * ResponseEntity<BloodDonor>(updated, new HttpHeaders(), HttpStatus.OK));
	 * return bloodDonorServiceImpl.addBloodDonor(bloodDonor); }
	 */
	
	 @RequestMapping(value = "/", method = RequestMethod.POST, produces ="application/json")
    public ResponseEntity<BloodDonor> createOrUpdateEmployee(@RequestBody BloodDonor bloodDonor)
            throws RecordNotFoundException {
		 bloodDonor.setBloodDonorId("BDID"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
    	BloodDonor updated = bloodDonorServiceImpl.addBloodDonor(bloodDonor);
return new ResponseEntity<BloodDonor>(updated, new HttpHeaders(), HttpStatus.OK);
}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public BloodDonor getBloodDonorById(@PathVariable int id) throws RecordNotFoundException {
 		return bloodDonorServiceImpl.getBloodDonor(id);
    }
	
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<BloodDonor> getBloodDonorAll() throws RecordNotFoundException {
 		return bloodDonorServiceImpl.getAllBloodDonor();
    }
	
	@CrossOrigin
  	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  	public Object deleteBloodDonor(@PathVariable int id) {
         return bloodDonorServiceImpl.deleteBloodDonor(id);
  		
  	}	
	
	@CrossOrigin
  	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
  	public Object updateBloodDonor(@RequestBody BloodDonor bloodDonor) {
         return bloodDonorServiceImpl.updateBloodDonor(bloodDonor);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/adblooddonorbyname",method = RequestMethod.POST,produces = "application/json")
	public Object adBloodDonor(@RequestBody BloodDonor bloodDonor) {
		return bloodDonorServiceImpl.adBloodDonor(bloodDonor);
		}

	@CrossOrigin
	@RequestMapping(value = "/lastsevendaysreport",method = RequestMethod.GET)
	public Object getLastSevenMonthReport() {
		return bloodDonorServiceImpl.getLastSevenDaysReport();
				
	}
	
	@CrossOrigin
	@RequestMapping(value = "/currentmonth",method = RequestMethod.GET)
    public Object getCurrentMonthReports() {
	    return bloodDonorServiceImpl.getCurrentMonthReports();
	
}
	@CrossOrigin
	@RequestMapping(value = "/currentyear",method = RequestMethod.GET)
	public Object getCurrentYearReports() {
		return bloodDonorServiceImpl.getCurrentYearReposrts();
		
	}

	@CrossOrigin
	@RequestMapping(value = "/lastthreemonth",method = RequestMethod.GET)
	public Object getLastThreeMonthsRecords() {
		return bloodDonorServiceImpl.getLastThreeMonthsReports();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/sixmonthrecord",method = RequestMethod.GET)
	public Object getLstSixMonthsRecords() {
		return bloodDonorServiceImpl.lastSixMonthRecords();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/lasttwelvemonth",method = RequestMethod.GET)
	public Object getLastTwelveMonthsReports() {
		return bloodDonorServiceImpl.getLastTwelveMonthsRecords();
		
	}
	@CrossOrigin
	@RequestMapping(value = "/donatedate/{donateDate}",method = RequestMethod.GET,produces = "application/json")
	public Object getByDate(@PathVariable Date donateDate) {
		return bloodDonorServiceImpl.getByDonatedDate(donateDate);
		
	}
	@CrossOrigin
	@RequestMapping(value = "/lastmontrecords",method = RequestMethod.GET)
	public Object getLastMonthreports() {
		return bloodDonorServiceImpl.getLastMonthReports();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public Object getAll() {
		return bloodDonorServiceImpl.getAllRecords();
		
	}
}
