package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.BedGroup;
import com.hms.management.repository.BedGroupRepository;
import com.hms.management.service.BedGroupService;

@Service
public class BedGroupServiceImpl implements BedGroupService{

	
	@Autowired
	public BedGroupRepository bedGroupRepository;

	@Override
	public BedGroup addBedGroup(BedGroup bedGroup) {
		 return bedGroupRepository.save(bedGroup);
	}
}
