package com.hms.management.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.Institution;
import com.hms.management.repository.InstitutionRepository;
import com.hms.management.service.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService{

	
	
	@Autowired
	public InstitutionRepository institutionRepository;

	
	@Override
	public Institution addInstitution(Institution institution) {
		Date d=new Date();
		institution.setDonatedDate(d);
		institution.setUpdatedAt(d);
		institution.setCreatedAt(d);
		institution.setInstuteId("INST-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
 		return institutionRepository.save(institution);
	}
}
