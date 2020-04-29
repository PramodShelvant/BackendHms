package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PostalDisPatchList;

public interface PostalDisPatchListService {

	
	
	public PostalDisPatchList addPostDisList(PostalDisPatchList postalDisPatchList) throws RecordNotFoundException;
 	public PostalDisPatchList getPostDisList(int id) throws RecordNotFoundException;
	public List<PostalDisPatchList> getAllPostDisList() throws RecordNotFoundException;
	public Object deletePostalDisPatchList(int id);
	public PostalDisPatchList addpostalDisPatchListServiceImpl(PostalDisPatchList postalDisPatchList);

}
