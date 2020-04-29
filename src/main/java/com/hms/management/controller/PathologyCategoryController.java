package com.hms.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.PathologyCategory;
import com.hms.management.serviceimpl.PathologyCategoryServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("pathologycategory")
public class PathologyCategoryController {

	
	
	@Autowired
	public PathologyCategoryServiceImpl PathologyCategorySrviceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public PathologyCategory addPathologyCategory(@RequestBody PathologyCategory pathologyCategory) {
		return PathologyCategorySrviceImpl.addPathologyCategory(pathologyCategory);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public Iterable<PathologyCategory> getAllPathologyCategory(){
		return PathologyCategorySrviceImpl.getAllPathologyCategory();
		
	}
}
