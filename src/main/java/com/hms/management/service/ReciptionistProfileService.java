package com.hms.management.service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.ReciptionistProfile;

public interface ReciptionistProfileService {

	public ReciptionistProfile getReciptionistProfile(int id) throws RecordNotFoundException;
	public Object changePassword(String oldPassword, String newPassword, String userId);
}
