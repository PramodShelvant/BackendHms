package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.PathologyCategory;
import com.hms.management.repository.PathologyCategoryRepository;
import com.hms.management.service.PathologyCategoryService;

@Service
public class PathologyCategoryServiceImpl implements PathologyCategoryService{
	
	@Autowired
	public PathologyCategoryRepository pathologyCategoryRepository;

	@Override
	public PathologyCategory addPathologyCategory(PathologyCategory pathologyCategory) {
 		return pathologyCategoryRepository.save(pathologyCategory);
	}

	@Override
	public Iterable<PathologyCategory> getAllPathologyCategory() {
 		return pathologyCategoryRepository.findAll();
	}

}
