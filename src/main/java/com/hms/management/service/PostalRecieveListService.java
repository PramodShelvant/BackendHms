package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PostalRecieveList;

public interface PostalRecieveListService {

	
	public PostalRecieveList addPostalRecieveList(PostalRecieveList postalRecieveList);
	public PostalRecieveList getpostalRecieveList(int id) throws RecordNotFoundException;
    public List<PostalRecieveList> getAllpostalRecieveList() throws RecordNotFoundException;
	public Object deletePostalRecieveList(int id);
	public PostalRecieveList adPostalRecieveList(PostalRecieveList postalRecieveList);
 
}
