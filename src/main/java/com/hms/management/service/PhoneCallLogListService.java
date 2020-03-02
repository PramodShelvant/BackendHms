package com.hms.management.service;

import java.util.List;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PhoneCallLogList;

public interface PhoneCallLogListService {

	public PhoneCallLogList addPhoneCalls(PhoneCallLogList phoneCallLogList) throws RecordNotFoundException;
    public PhoneCallLogList getphoneCalls(int id) throws RecordNotFoundException;
    public List<PhoneCallLogList> getAllphoneCalls() throws RecordNotFoundException;
	public PhoneCallLogList UpdatePhoneCalls(PhoneCallLogList phoneCallLogList) throws RecordNotFoundException;
	public Object deletePhoneCallLogList(int id);
 


}
