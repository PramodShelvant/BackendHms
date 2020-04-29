package com.hms.management.service;

import com.hms.management.model.PathologyCategory;

public interface PathologyCategoryService {

	
	
	public PathologyCategory addPathologyCategory(PathologyCategory pathologyCategory);
	public Iterable<PathologyCategory> getAllPathologyCategory();
}
