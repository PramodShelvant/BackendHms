package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.PostalDisPatchListBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PostalDisPatchList;
import com.hms.management.serviceimpl.PostalDisPatchListServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/postaldispatchlist")
public class PostalDisPatchListController {
	
	
	private static String UPLOADED_FOLDER = "uploads/";

	@Autowired
	public PostalDisPatchListServiceImpl postalDisPatchListServiceImpl;
 	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public PostalDisPatchList addInPatient(PostalDisPatchListBean postalDisPatchListBean) throws RecordNotFoundException {
		PostalDisPatchList n=new PostalDisPatchList();
 	        byte[] bytes = null;
			try {
				bytes = postalDisPatchListBean.getAttachdDocument().getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
	        Path path = Paths.get(UPLOADED_FOLDER + postalDisPatchListBean.getAttachdDocument().getOriginalFilename());
	        try {
				Files.write(path, bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         n.setAttachdDocument(UPLOADED_FOLDER + postalDisPatchListBean.getAttachdDocument().getOriginalFilename());
			 n.setAddress(postalDisPatchListBean.getAddress());
			 n.setDate(postalDisPatchListBean.getDate());
			 n.setFromTitle(postalDisPatchListBean.getFromTitle());
			 n.setReferenceNo(postalDisPatchListBean.getReferenceNo());
			 n.setNote(postalDisPatchListBean.getNote());
			 n.setToTitle(postalDisPatchListBean.getToTitle()); 
			 n.setId(postalDisPatchListBean.getId());
		     return postalDisPatchListServiceImpl.addPostDisList(n);
  	       }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public PostalDisPatchList getEmployeeById(@PathVariable int id) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of PhoneCallLogList", postalDisPatchListServiceImpl.getPostDisList(id));
		return postalDisPatchListServiceImpl.getPostDisList(id);
    }

	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<PostalDisPatchList> getAllPostalDisPatchList() throws RecordNotFoundException {
  		return postalDisPatchListServiceImpl.getAllPostDisList();
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deletePostalDisPatchList(@PathVariable int id) {
		return postalDisPatchListServiceImpl.deletePostalDisPatchList(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/iffileisnull",method = RequestMethod.POST,produces = "application/json")
	public PostalDisPatchList addPostalDisPatchList(@RequestBody PostalDisPatchList postalDisPatchList) {
		System.out.println("hello");
		return postalDisPatchListServiceImpl.addpostalDisPatchListServiceImpl(postalDisPatchList);
		
	}
}
