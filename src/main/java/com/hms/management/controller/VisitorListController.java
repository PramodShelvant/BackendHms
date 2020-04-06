package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.VisitorListBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.VisitorList;
import com.hms.management.serviceimpl.VisitorListServiceImpl;
 

@CrossOrigin
@RestController
@RequestMapping("/visitorlist")
public class VisitorListController {

	
	
	
	private static String UPLOADED_FOLDER = "uploads/";

	@Autowired
	public VisitorListServiceImpl visitorListServiceImpl;
	
	@CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object addVisitors(VisitorListBean visitorListBean) throws RecordNotFoundException {
		Map<String,Object> map=new HashMap<String, Object>();
		System.out.println(visitorListBean.getIdCard()+"-<----id cart----.number of persons "+visitorListBean.getNumberOfPersons());
		VisitorList n=new VisitorList();
		System.out.println(n.getIdCard()+"-<----id cart----.number of persons "+n.getNumberOfPersons());
        byte[] bytes = null;
		try {
 				bytes = visitorListBean.getAttachedDocument().getBytes();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + visitorListBean.getAttachedDocument().getOriginalFilename());
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setAttachedDocument(UPLOADED_FOLDER + visitorListBean.getAttachedDocument().getOriginalFilename());
	    n.setPurpose(visitorListBean.getPurpose());
        n.setName(visitorListBean.getName());
        n.setPhone(visitorListBean.getPhone());
        n.setIdCard(visitorListBean.getIdCard());
        n.setNumberOfPersons(visitorListBean.getNumberOfPersons());
        Date d=new Date();
        n.setDate(d);
        n.setInTime(visitorListBean.getInTime());
        n.setOutTime(visitorListBean.getOutTime());
        n.setAction(visitorListBean.getAction());
        n.setNote(visitorListBean.getNote());
        n.setId(visitorListBean.getId());
		return visitorListServiceImpl.addVisitors(n);
	}
    
    @CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public VisitorList getByIdVisitorList(@PathVariable int id) throws RecordNotFoundException {
 		return visitorListServiceImpl.getVisitorList(id);
    }
    
    @CrossOrigin
    @RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<VisitorList> getComplainTypeAll() throws RecordNotFoundException {
		 return visitorListServiceImpl.getAllVisitorList();
    }
    
    @CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteVisitorList(@PathVariable int id) {
		return visitorListServiceImpl.deleteVisitorList(id);
		
	}
    
    @RequestMapping(value = "/iffileisnull",method = RequestMethod.POST,produces = "application/json")
    public VisitorList adVisitor(@RequestBody VisitorList visitorList) {
		return visitorListServiceImpl.adVisitorList(visitorList);
    	
    }
}
