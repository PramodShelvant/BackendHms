package com.hms.management.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OpdOutPatient;
import com.hms.management.model.UserRegistration;
import com.hms.management.repository.OpdOutPatientRepository;
import com.hms.management.repository.UserRegistrationRepository;
import com.hms.management.service.OpdOutPatientService;

@Service
public class OpdOutPatientServiceImpl implements OpdOutPatientService{

	
	@Autowired
	public OpdOutPatientRepository opdOutPatientRepository;

	@Autowired
	public UserRegistrationRepository userRepo;

	@Override
	public OpdOutPatient addOutPatient(OpdOutPatient opdOutPatient) throws RecordNotFoundException{
		opdOutPatient.setOpdId("OPDID-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
 		return opdOutPatientRepository.save(opdOutPatient);
	}
	@Override
	public OpdOutPatient getOpdOutPatientById(int id) throws RecordNotFoundException {
		return opdOutPatientRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No opdOutPatient record exist for given id"));
		 	}

	@Override
	public List<OpdOutPatient> getAllOpdOutPatient() throws RecordNotFoundException {
		  return opdOutPatientRepository.findAll();
	}
	
	@Override
	public Object getByPatientId(String patientId) {
		List<Map<String, Object>> response=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
			List<OpdOutPatient> inn=opdOutPatientRepository.findByPatientId(patientId);
	        System.out.println("totalVisit---------->"+inn.size());
	        map.put("totalVisit", inn.size());
		if(inn.size()!=0) {
			//InPatient i=inn.get(0);
	        System.out.println("totalVisit---------->"+inn.size());

			
            for(OpdOutPatient in:inn) {
            	map=new HashMap<>();
  		
		map.put("appliedCharge", in.getAppliedCharge());
		map.put("appointmentDate", in.getAppointmentDate());
		map.put("bp", in.getBp());
		map.put("caseType", in.getCaseType());
		map.put("casuality", in.getCasuality());
 		map.put("doctorName", in.getDoctorName());
		map.put("height", in.getHeight());
		map.put("id", in.getId());
		map.put("name", in.getName());
		map.put("note", in.getNote());
		map.put("oldPatient", in.getOldPatient());
		map.put("opdId", in.getOpdId());
		map.put("patientId", in.getPatientId());
		map.put("paymentMode", in.getPaymentMode());
		map.put("standardCharger", in.getStandardCharge());
		map.put("symptoms", in.getSymptoms());
		map.put("tpa", in.getTpa());
		map.put("weight", in.getWeight());
        map.put("doctorId", in.getDoctorId());
        map.put("totalVisit", inn.size());
        System.out.println("totalVisit---------->"+inn.size());
         String b=in.getPatientId();
		if(in.getPatientId()!=null) {
		UserRegistration k=userRepo.findByUserId(b);
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
	public Object getByDocterId() {
		
	Map<Object,Object> map=new HashMap<>();
map.put("userProfile",userRepo.findByRole("patient"));
	map.put("opd",opdOutPatientRepository.findAll().stream().collect(Collectors.groupingBy(OpdOutPatient::getPatientId)));
//		List<Object> li=new ArrayList<>();
//		opdOutPatientRepository.fetchOpdPatient().forEach(item->
//		{Map<Object,Object> map=new HashMap<>();
//		map.put("admissionDate",item[0]);
//		map.put("name",item[1]);
//		map.put("mobileNumber",item[2]);
//		map.put("gender",item[3]);
//		map.put("patientId",item[4]);
//		li.add(map);});
//		
		//map.put("opd",);
		return map;
		//return li;
	}
	
	@Override
	public Object deleteOpdOutPatient(int id) {
		Map<String, Object> map=new HashMap<>();
		opdOutPatientRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
	
	public Object getPatient() {
		//Map<String, Object> map=new HashMap<>();
		
		//map.put("status", 1);
 		return opdOutPatientRepository.fetchOpdPatient();
	}
	@Override
	public Object getByDId(String doctorId) {
		List<Map<String, Object>> response=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
			List<OpdOutPatient> inn=opdOutPatientRepository.findByDoctorId(doctorId);
		if(inn.size()!=0) {
			//InPatient i=inn.get(0);
            for(OpdOutPatient in:inn) {
            	map=new HashMap<>();
  		
		map.put("appliedCharge", in.getAppliedCharge());
		map.put("appointmentDate", in.getAppointmentDate());
		map.put("bp", in.getBp());
		map.put("caseType", in.getCaseType());
		map.put("casuality", in.getCasuality());
 		map.put("doctorName", in.getDoctorName());
		map.put("height", in.getHeight());
		map.put("id", in.getId());
		map.put("name", in.getName());
		map.put("note", in.getNote());
		map.put("oldPatient", in.getOldPatient());
		map.put("opdId", in.getOpdId());
		map.put("patientId", in.getPatientId());
		map.put("paymentMode", in.getPaymentMode());
		map.put("standardCharger", in.getStandardCharge());
		map.put("symptoms", in.getSymptoms());
		map.put("tpa", in.getTpa());
		map.put("weight", in.getWeight());
        map.put("doctorId", in.getDoctorId());
         String b=in.getPatientId();
		if(in.getPatientId()!=null) {
		UserRegistration k=userRepo.findByUserId(b);
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
