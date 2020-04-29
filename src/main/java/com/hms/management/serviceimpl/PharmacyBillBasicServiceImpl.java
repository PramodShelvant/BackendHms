package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.PatientRegistration;
import com.hms.management.model.PharmacyBillBasic;
import com.hms.management.repository.PharmacyBillBasicRepository;
import com.hms.management.service.PharmacyBillBasicService;


@Service
public class PharmacyBillBasicServiceImpl implements PharmacyBillBasicService{

	
	
	
	@Autowired
	public PharmacyBillBasicRepository pharmacyBillBasicRepository;
	
	
	@Autowired
	public PatientRegistrationRepository patientRegistrationRepository;
	
	
	
	
	@Override
	public PharmacyBillBasic addPharmacyBillBasic(PharmacyBillBasic pharmacyBillBasic) {
 		return pharmacyBillBasicRepository.save(pharmacyBillBasic);
	}

	@Override
	public List<PharmacyBillBasic> getAllPharmacyBillBasic() {
 		return pharmacyBillBasicRepository.findAll();
	}

	@Override
	public Object getByPatientId(String patientId) {
		Map<String, Object> map=new HashMap<>();
		
		PharmacyBillBasic ph=pharmacyBillBasicRepository.findByPatientId(patientId);
		if(ph!=null) {
			map.put("action", ph.getAction());
			map.put("billNo", ph.getBillNo());
			map.put("createdAt", ph.getCreatedAt());
			map.put("customerName", ph.getCustomerName());
			map.put("customerType", ph.getCustomerType());
			map.put("date", ph.getDate());
			map.put("disCount", ph.getDiscount());
			map.put("doctorName", ph.getDoctorName());
			map.put("id", ph.getId());
			map.put("netAmount", ph.getNetAmount());
			map.put("note", ph.getNote());
			map.put("opdIdNo", ph.getOpdIpdNo());
			map.put("", ph.getPatientId());
			map.put("tax", ph.getTax());
			map.put("total", ph.getTotal());
			map.put("update", ph.getUpdatedAt());
			PatientRegistration pr=patientRegistrationRepository.findByPatientId(patientId);
			if(pr!=null) {
				map.put("patientName", pr.getPatientName());
			}else {
				map.put("msg", "no records found for the given patient id");
			}
		}else {
			map.put("msg", "no records found for the given patient id");
		}
 		return map;
	}

}
