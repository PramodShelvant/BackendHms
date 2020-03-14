package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.BirthRecordBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BirthRecord;
import com.hms.management.serviceimpl.BirthRecordServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("birthRecord")
public class BirthRecordController {

	
	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//D//";

	@Autowired
	public BirthRecordServiceImpl birthRecordServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public Object addBirthRecord(BirthRecordBean BirthRecordBean) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String, Object>();
		BirthRecord n=new BirthRecord();
        byte[] bytes = null;
		try {
			bytes = BirthRecordBean.getChildPhoto().getBytes();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + BirthRecordBean.getChildPhoto().getOriginalFilename());
         try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        n.setChildName(BirthRecordBean.getChildName());
        n.setAddress(BirthRecordBean.getAddress());
        n.setBirthDate(BirthRecordBean.getBirthDate());
        n.setPhone(BirthRecordBean.getPhone());
        n.setMotherName(BirthRecordBean.getMotherName());
        n.setIpdOrOpdNo(BirthRecordBean.getIpdOrOpdNo());
        n.setFatherName(BirthRecordBean.getFatherName());
        n.setGender(BirthRecordBean.getGender());
		return birthRecordServiceImpl.addBirthRecord(n);
	}
	@CrossOrigin
    @RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<BirthRecord> getAllBirthRecord() throws RecordNotFoundException {
		 return birthRecordServiceImpl.getAllBirthRecord(); 
    }
	@CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public BirthRecord getAllBirthRecordById(@PathVariable int id) throws RecordNotFoundException {
		 return birthRecordServiceImpl.getBirthRecord(id);
    }
	@CrossOrigin
  	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  	public Object deleteBirthRecord(@PathVariable int id) {
         return birthRecordServiceImpl.deleteBirthRecord(id);
  		
  	}	
	@CrossOrigin
	@RequestMapping(value = "/iffileisnull",method = RequestMethod.POST,produces = "application/json")
	public BirthRecord addBirthrecird(BirthRecord birthRecord) {
		return birthRecordServiceImpl.adBirthRecord(birthRecord);
		
	}

 }

