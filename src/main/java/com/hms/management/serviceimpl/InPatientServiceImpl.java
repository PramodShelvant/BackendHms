package com.hms.management.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.InPatient;
import com.hms.management.model.UserRegistration;
import com.hms.management.repository.InPatientRepository;
import com.hms.management.repository.UserRegistrationRepository;
import com.hms.management.service.InPatientService;

@Service
public class InPatientServiceImpl implements InPatientService{

	
	@Autowired
	public InPatientRepository inPatientRepository;
	
	
	@Autowired
	public UserRegistrationRepository userRegistrationRepository;

	@Override
	public InPatient addInPatient(InPatient inPatient) throws RecordNotFoundException {
		inPatient.setIpdId("IPDID-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
		inPatient.setDisChargeStatus("NO");
	
 		return inPatientRepository.save(inPatient);
	}

	@Override
	public Object getInPatient(String patientId,String status)   {
		List<Map<String, Object>> response=new ArrayList<>();
 		UserRegistration u=userRegistrationRepository.findByUserId(patientId);
		List<InPatient> k=inPatientRepository.findByPatientIdAndDisChargeStatus(patientId,status);
		if(u!=null) {
			for(InPatient in:k) {
			Map<String, Object>  map=new HashMap<>();
			map.put("name", u.getName());
			map.put("phone", u.getMobileNo());
			map.put("gender", u.getGender());
			map.put("bedgroup", in.getBedGroup());
			map.put("bednumber", in.getBedNumber());
			map.put("bp", in.getBp());
			map.put("casetype", in.getCaseType());
			map.put("casulity", in.getCasulity());
			map.put("doctorName", in.getDoctorName());
			map.put("creditlimit", in.getCreditLimit());
			map.put("statue", in.getDisChargeStatus());
			map.put("weight", in.getWeight());
			map.put("tpa", in.getTpa());
			map.put("symptoms", in.getSymptoms());
			map.put("patientId", in.getPatientId());
			map.put("oldPatient", in.getOldPatient());
			map.put("note", in.getNote());
			map.put("height", in.getHeight());
			map.put("doctorId", in.getDoctorId());
			map.put("ipdId",in.getIpdId());
			response.add(map);
			}
			
           }
		return response;
 	}


	@Override
	public List<InPatient> getAllInPatient() throws RecordNotFoundException {
		 return inPatientRepository.findAll();
	}

	@Override
	public Object deleteInPatient(int id) {
		Map<String, Object> map=new HashMap<>();
		inPatientRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

	 

	@Override
	public Object getByDoctorId(String doctorId, String disChargeStatus) {
 		
 		System.out.println("doctorId");
		List<Map<String, Object>> response=new ArrayList<>();
			Map<String, Object>  map=new HashMap<>();
 			List<InPatient> inn=inPatientRepository.findByDoctorIdAndDisChargeStatus(doctorId,disChargeStatus);
			if(inn.size()!=0) {
				//InPatient i=inn.get(0);
                for(InPatient in:inn) {
                	map=new HashMap<>();
            map.put("bedgroup", in.getBedGroup());
			map.put("bednumber", in.getBedNumber());
			map.put("bp", in.getBp());
			map.put("casetype", in.getCaseType());
			map.put("casulity", in.getCasulity());
			map.put("doctorName", in.getDoctorName());
			map.put("creditlimit", in.getCreditLimit());
			map.put("statue", in.getDisChargeStatus());
			map.put("weight", in.getWeight());
			map.put("tpa", in.getTpa());
			map.put("symptoms", in.getSymptoms());
			map.put("patientId", in.getPatientId());
			map.put("oldPatient", in.getOldPatient());
			map.put("note", in.getNote());
			map.put("height", in.getHeight());
			map.put("doctorId", in.getDoctorId());
			map.put("ipdId", in.getIpdId());
			map.put("disChargeDate", in.getDisChargeDate());
			map.put("disChargeStatus", in.getDisChargeStatus());
			map.put("summury",in.getSummer());
            String b=in.getPatientId();
			if(in.getPatientId()!=null) {
			UserRegistration k=userRegistrationRepository.findByUserId(b);
		        if(k!=null) {
				map.put("name", k.getName());
				map.put("phone", k.getMobileNo());
				map.put("gender", k.getGender());
 		        response.add(map);
				}
			}
			}
 		
 	}
			return response;
	}
	
	@Override
 	public Object getAll() {
		
		List<Map<String, Object>> response=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
			List<InPatient> inn=inPatientRepository.findAll();
		if(inn.size()!=0) {
			//InPatient i=inn.get(0);
            for(InPatient in:inn) {
            	map=new HashMap<>();
        map.put("bedgroup", in.getBedGroup());
		map.put("bednumber", in.getBedNumber());
		map.put("bp", in.getBp());
		map.put("casetype", in.getCaseType());
		map.put("casulity", in.getCasulity());
		map.put("doctorName", in.getDoctorName());
		map.put("creditlimit", in.getCreditLimit());
		map.put("statue", in.getDisChargeStatus());
		map.put("weight", in.getWeight()); 
		map.put("tpa", in.getTpa());
		map.put("symptoms", in.getSymptoms());
		map.put("patientId", in.getPatientId());
		map.put("oldPatient", in.getOldPatient());
		map.put("note", in.getNote());
		map.put("height", in.getHeight());
		map.put("doctorId", in.getDoctorId());
		map.put("ipdId", in.getIpdId());
        String b=in.getPatientId();
		if(in.getPatientId()!=null) {
		UserRegistration k=userRegistrationRepository.findByUserId(b);
	        if(k!=null) {
			map.put("name", k.getName());
			map.put("phone", k.getMobileNo());
			map.put("gender", k.getGender());
		    response.add(map);
			}
		}
		}
		
	}
		return response;
		
	}

	@Override
	public InPatient updateIpdDisCharge(InPatient inPatient) {
		InPatient i=inPatientRepository.findByIpdId(inPatient.getIpdId());
		if(i!=null) {
			i.setDisChargeDate(inPatient.getDisChargeDate());
			i.setSummer(inPatient.getSummer());
		    i.setDisChargeStatus("YES");
			
		}
  		return inPatientRepository.save(i);
	}

	
	@Override
	public Object getByDisChargeStatus(String disChargeStatus) {
		List<Map<String, Object>> response=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
			List<InPatient> inn=inPatientRepository.findByDisChargeStatus(disChargeStatus);
		if(inn.size()!=0) {
			//InPatient i=inn.get(0);
            for(InPatient in:inn) {
            	map=new HashMap<>();
        map.put("bedgroup", in.getBedGroup());
		map.put("bednumber", in.getBedNumber());
		map.put("bp", in.getBp());
		map.put("casetype", in.getCaseType());
		map.put("casulity", in.getCasulity());
		map.put("doctorName", in.getDoctorName());
		map.put("creditlimit", in.getCreditLimit());
		map.put("statue", in.getDisChargeStatus());
		map.put("weight", in.getWeight());
		map.put("tpa", in.getTpa());
		map.put("symptoms", in.getSymptoms());
		map.put("patientId", in.getPatientId());
		map.put("oldPatient", in.getOldPatient());
		map.put("note", in.getNote());
		map.put("height", in.getHeight());
		map.put("doctorId", in.getDoctorId());
		map.put("ipdId", in.getIpdId());
		map.put("disChargeDate", in.getDisChargeDate());
		map.put("disChargeStatus", in.getDisChargeStatus());
		map.put("summury",in.getSummer());
        String b=in.getPatientId();
		if(in.getPatientId()!=null) {
		UserRegistration k=userRegistrationRepository.findByUserId(b);
	        if(k!=null) {
			map.put("name", k.getName());
			map.put("phone", k.getMobileNo());
			map.put("gender", k.getGender());
		        response.add(map);
			}
		}
		}
		
	}

 		return response;
	}

   
}

