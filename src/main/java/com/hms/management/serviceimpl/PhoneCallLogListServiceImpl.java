package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.PhoneCallLogList;
import com.hms.management.repository.PhoneCallLogListRepository;
import com.hms.management.service.PhoneCallLogListService;
 
@Service
public class PhoneCallLogListServiceImpl implements PhoneCallLogListService{

	
	@Autowired
	public PhoneCallLogListRepository phoneCallLogListRepository;

	@Override
	public PhoneCallLogList addPhoneCalls(PhoneCallLogList phoneCallLogList) throws RecordNotFoundException {
         return phoneCallLogListRepository.save(phoneCallLogList);
	}

	@Override
	public PhoneCallLogList getphoneCalls(int id) throws RecordNotFoundException {
 		 return phoneCallLogListRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no records PhoneCallLogList for this id"));
	}

	@Override
	public List<PhoneCallLogList> getAllphoneCalls() throws RecordNotFoundException {
 		return phoneCallLogListRepository.findAll();
	}
	 
	@Override
	public PhoneCallLogList UpdatePhoneCalls(PhoneCallLogList phoneCallLogList) throws RecordNotFoundException {
		Optional<PhoneCallLogList> l= phoneCallLogListRepository.findById(phoneCallLogList.getId());
		if(l.isPresent()) {
			PhoneCallLogList p = l.get();
            if(p.getName()!=null){
            p.setName(phoneCallLogList.getName());}
            if(phoneCallLogList.getCallDuretion()!=null) {
            p.setCallDuretion(phoneCallLogList.getCallDuretion());}
            if(phoneCallLogList.getCallType()!=null) {
            p.setCallType(phoneCallLogList.getCallType());}
            if(phoneCallLogList.getDate()!=null) {
            p.setDate(phoneCallLogList.getDate());}
            if(phoneCallLogList.getNextFallowUpDate()!=null) {
            p.setNextFallowUpDate(phoneCallLogList.getNextFallowUpDate());}
            p = phoneCallLogListRepository.save(p);
            return p;
        } else {
        	phoneCallLogList = phoneCallLogListRepository.save(phoneCallLogList);
            return phoneCallLogList;
        }
 	}
    @Override
	public Object deletePhoneCallLogList(int id) {
		Map<String, Object> map=new HashMap<String, Object>();
 		phoneCallLogListRepository.deleteById(id);
 		map.put("status", 1);
 		return map;
	}

}
