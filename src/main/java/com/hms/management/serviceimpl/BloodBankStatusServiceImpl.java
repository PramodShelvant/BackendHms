package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.BloodBankStatus;
import com.hms.management.repository.BloodBankStatusRepository;
import com.hms.management.service.BloodBankStatusService;

@Service
public class BloodBankStatusServiceImpl implements BloodBankStatusService{

	
	@Autowired
	public BloodBankStatusRepository bloodBankStatusRepository;

	@Override
	public BloodBankStatus addBloodBankStatus(BloodBankStatus bloodBankStatus) {
		return bloodBankStatusRepository.save(bloodBankStatus);
	}

	@Override
	public List<BloodBankStatus> getBloodBankStatus() {
 		return bloodBankStatusRepository.findAll();
	}

	@Override
	public Object getByBloodGroup(String bloodGroup) {
		Map<String, Object> map=new HashMap<>();
		List<BloodBankStatus> blood=bloodBankStatusRepository.findByBloodGroup(bloodGroup);
		if(blood.size()!=0) {
			for(BloodBankStatus bld:blood) {
				map.put("bllodGroup", bld.getBloodGroup());
				map.put("bloodStatus", blood.size());
			}
		}else {
			map.put("msg", "no blood bags are available on this group");
		}
		return map;
 	}

}
