package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import com.hms.management.beans.PostalRecieveListBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PostalRecieveList;
import com.hms.management.serviceimpl.PostalRecieveListServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/postalrecieve")
public class PostalRecieveListController {
	
	
	
	private static String UPLOADED_FOLDER = "uploads/";

	@Autowired
	public PostalRecieveListServiceImpl postalRecieveListServiceImpl;

	@CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
     public Object addPostalRecievedList(PostalRecieveListBean postalRecieveListBean) throws RecordNotFoundException {
		Map<String,Object> map=new HashMap<String, Object>();
		PostalRecieveList n=new PostalRecieveList();
         byte[] bytes = null;
		try {
			bytes = postalRecieveListBean.getAttachDocument().getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + postalRecieveListBean.getAttachDocument().getOriginalFilename());
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setAttachdocument(UPLOADED_FOLDER + postalRecieveListBean.getAttachDocument().getOriginalFilename());
		n.setFromTitle(postalRecieveListBean.getFromTitle());
		n.setToTitle(postalRecieveListBean.getToTitle());
		n.setDate(postalRecieveListBean.getDate());
		n.setReferenceNo(postalRecieveListBean.getReferenceNo());
		n.setAddress(postalRecieveListBean.getAddress());
		n.setNote(postalRecieveListBean.getNote());
		n.setId(postalRecieveListBean.getId());
        return postalRecieveListServiceImpl.addPostalRecieveList(n);
    }

 	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public PostalRecieveList getByIdPostalRecieveList(@PathVariable int id) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("details of postalRecieveListDetails", postalRecieveListServiceImpl.getpostalRecieveList(id));
		return postalRecieveListServiceImpl.getpostalRecieveList(id);
    }
	@CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
	 public List<PostalRecieveList> getAllPostalRecieveList() throws RecordNotFoundException {
 		return postalRecieveListServiceImpl.getAllpostalRecieveList();
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deletePostalRecieveList(@PathVariable int id) {
		return postalRecieveListServiceImpl.deletePostalRecieveList(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "iffileisnull",method = RequestMethod.POST,produces = "application/json")
	public PostalRecieveList adPostalRecieveList(@RequestBody PostalRecieveList postalRecieveList) {
		return postalRecieveListServiceImpl.adPostalRecieveList(postalRecieveList);
		
	}
}
