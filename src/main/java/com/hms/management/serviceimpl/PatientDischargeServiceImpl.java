package com.hms.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.InPatient;
import com.hms.management.model.IpdBilling;
import com.hms.management.model.PatientDischarge;
import com.hms.management.model.UserRegistration;
import com.hms.management.repository.ChargesRepository;
import com.hms.management.repository.InPatientRepository;
import com.hms.management.repository.IpdBillingRepository;
import com.hms.management.repository.PatientDischargeRepository;
import com.hms.management.repository.UserRegistrationRepository;
import com.hms.management.service.PatientDischargeService;

@Service
public class PatientDischargeServiceImpl implements PatientDischargeService{

	
	
	@Autowired
	public PatientDischargeRepository patientDischargeRepository;
	
	@Autowired
	public InPatientRepository inPatientRepository;
	
	@Autowired 
	public UserRegistrationRepository userRegistrationRepository;
	
	@Autowired
	public ChargesRepository chargesRepository;
	
	@Autowired
	public IpdBillingRepository ipdBillingRepository;

	
	/*
	 * @Override public PatientDischarge addPatientDischarge(PatientDischarge
	 * patientDischarge) { System.out.println("jjkkjhj"+patientDischarge); InPatient
	 * ip=inPatientRepository.findByPatientId(patientDischarge.getPatientId());
	 * UserRegistration
	 * c=userRegistrationRepository.findByUserId(patientDischarge.getPatientId());
	 * IpdBilling
	 * bl=ipdBillingRepository.findByPatientId(patientDischarge.getPatientId());
	 * 
	 * if(ip!=null) { patientDischarge.setAdmissionbDate(ip.getAppointmentDate());
	 * //patientDischarge.se); patientDischarge.setName(c.getName());
	 * patientDischarge.setGender(c.getGender());
	 * patientDischarge.setPhone(c.getMobileNo());
	 * patientDischarge.setTax(bl.getTax());
	 * patientDischarge.setDiscount(bl.getDiscount());
	 * patientDischarge.setOtherCharges(bl.getOtherCharge());
	 * patientDischarge.setPaidAmount(bl.getTotalAmount());
	 * 
	 * }
	 * 
	 * return patientDischargeRepository.save(patientDischarge); }
	 */
}
