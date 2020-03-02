package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.MedicianDetails;
import com.hms.management.repository.MedicianDetailsRepository;
import com.hms.management.service.MedicianDetailsservice;

@Service
public class MedicianDetailsServiceImpl implements MedicianDetailsservice{

	
	@Autowired
	public MedicianDetailsRepository  medicianDetailsRepository;

	@Override
	@Transactional
	public MedicianDetails addMedicianDetails(MedicianDetails medicianDetails) {
		//medicianDetails.setBillNo(DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
 		return medicianDetailsRepository.save(medicianDetails);
	}
	@Override
	public MedicianDetails getMedicianDetails(int mid) throws RecordNotFoundException{
		Optional<MedicianDetails> p = medicianDetailsRepository.findByMid(mid);
		//MedicianDetails mn = medicianDetailsRepository;

        if(p.isPresent()) {
          return p.get();
      } else {
          throw new RecordNotFoundException("No medicianDetails record exist for given id");
      }
 	}
	
	@Override
	public Object deleteMedicianDetails(int id) {
		Map<String, Object> map=new HashMap<>();
		medicianDetailsRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
}
