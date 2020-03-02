package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodDonor;
import com.hms.management.repository.BloodDonorRepository;
import com.hms.management.service.BloodDonorService;

@Service
public class BloodDonorServiceImpl implements BloodDonorService{

	
	@Autowired
	public BloodDonorRepository bloodDonorRepository;

	@Override
	public BloodDonor addBloodDonor(BloodDonor bloodDonor) {
		Date d=new Date();
		bloodDonor.setUpdatedAt(d);
		bloodDonor.setCreatedAt(d);
 		return bloodDonorRepository.save(bloodDonor);
	}

	@Override
	public BloodDonor getBloodDonor(int id) throws RecordNotFoundException {
 		return bloodDonorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no BloodDonor records for this id"));
	}

	@Override
	public List<BloodDonor> getAllBloodDonor() throws RecordNotFoundException {
 		return bloodDonorRepository.findAll();
	}

	@Override
	public Object deleteBloodDonor(int id) {
		Map<String, Object> map=new HashMap<>();
		bloodDonorRepository.deleteById(id);
		map.put("status", 1);
		return map;
	}

	@Override
	public Object updateBloodDonor(BloodDonor bloodDonor) {
		Map<String, Object> map=new HashMap<>();
		Optional<BloodDonor> al=bloodDonorRepository.findById(bloodDonor.getId());
		if(al.isPresent()) {
			BloodDonor bl=al.get();
			if(bl.getAddress()!=null) {
				bl.setAddress(bloodDonor.getAddress());}
			if(bl.getAge()!=null) {
				bl.setAge(bloodDonor.getAge());}
			if(bl.getBloodGroup()!=null) {
				bl.setBloodGroup(bloodDonor.getBloodGroup());}
			if(bl.getContactNo()!=null) {
				bl.setContactNo(bloodDonor.getContactNo());}
			if(bl.getCreatedAt()!=null) {
				bl.setCreatedAt(bloodDonor.getCreatedAt());}
			if(bl.getDonorName()!=null) {
				bl.setDonorName(bloodDonor.getDonorName());}
			if(bl.getGender()!=null) {
				bl.setGender(bloodDonor.getGender());}
			if(bl.getId()!=0) {
				bl.setId(bloodDonor.getId());}
			if(bl.getMonth()!=null) {
				bl.setMonth(bloodDonor.getMonth());}
			if(bl.getUpdatedAt()!=null) {
				bl.setUpdatedAt(bloodDonor.getUpdatedAt());}
                map.put("updated data", bloodDonorRepository.save(bl));
                return map;
		    }else {
                map.put("msg", "appointment status not found");
         		return map ;
            }
      }
 }










