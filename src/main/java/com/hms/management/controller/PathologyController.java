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
import com.hms.management.model.Pathology;
import com.hms.management.serviceimpl.PathologyServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("pathology")
public class PathologyController {

	
	@Autowired
	public PathologyServiceImpl pathologyServiceImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
     public Pathology addPythology(@RequestBody Pathology pathology) throws RecordNotFoundException{
 		//Map<String, Object> map=new HashMap<String, Object>();
 		//Pathology updated = pathologyServiceImpl.addPathology(pathology);
        //map.put("data saved", new ResponseEntity<Pathology>(updated, new HttpHeaders(), HttpStatus.OK));
        return pathologyServiceImpl.addPathology(pathology);
        }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	    public  Pathology getByIdPathology(@PathVariable int id) throws RecordNotFoundException {
 		//Map<String, Object> map=new HashMap<String, Object>();
        //Pathology p = pathologyServiceImpl.getPathology(id);
        //map.put("pathology details", new ResponseEntity<Pathology>(p, new HttpHeaders(), HttpStatus.OK));
		return pathologyServiceImpl.getPathology(id);

 	    }
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}","doctor/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<Pathology> getAllPathology() throws RecordNotFoundException{
        return pathologyServiceImpl.getAllPathology();
       }

	@CrossOrigin
	@RequestMapping(value = "patient/{patientId}", method = RequestMethod.GET, produces = "application/json")
	    public  Pathology getByPatientId(@PathVariable String patientId) throws RecordNotFoundException {
 		//Map<String, Object> map=new HashMap<String, Object>();
        //Pathology p = pathologyServiceImpl.getPathology(id);
        //map.put("pathology details", new ResponseEntity<Pathology>(p, new HttpHeaders(), HttpStatus.OK));
		return pathologyServiceImpl.getByPatientid(patientId);
	}
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deletePathology(@PathVariable int id) {
		return pathologyServiceImpl.deletePathology(id);
		
	}
}
