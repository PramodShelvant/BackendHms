package com.hms.management.controller;

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
import com.hms.management.model.PhoneCallLogList;
import com.hms.management.serviceimpl.PhoneCallLogListServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/phonecall")
public class PhoneCallLogListController {

	
	@Autowired
	public PhoneCallLogListServiceImpl phoneCallLogListServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public PhoneCallLogList addPhoneCalls(@RequestBody PhoneCallLogList phoneCallLogList) throws RecordNotFoundException{
  		return phoneCallLogListServiceImpl.addPhoneCalls(phoneCallLogList);
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public PhoneCallLogList getEmployeeById(@PathVariable int id) throws RecordNotFoundException {
 		return phoneCallLogListServiceImpl.getphoneCalls(id);
    }

	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<PhoneCallLogList> getAllphoneCalls() throws RecordNotFoundException {
 		return phoneCallLogListServiceImpl.getAllphoneCalls();
	}

	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
      public ResponseEntity<PhoneCallLogList> createOrUpdateEmployee(@RequestBody PhoneCallLogList phoneCallLogList)
                                                    throws RecordNotFoundException {
		PhoneCallLogList updated = phoneCallLogListServiceImpl.UpdatePhoneCalls(phoneCallLogList);
        return new ResponseEntity<PhoneCallLogList>(updated, new HttpHeaders(), HttpStatus.OK);
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deletePhoneCallLogList(@PathVariable int id) {
		return phoneCallLogListServiceImpl.deletePhoneCallLogList(id);
		
	}
}
