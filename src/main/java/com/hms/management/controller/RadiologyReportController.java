package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.RadiologyReportBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.RadiologyReport;
import com.hms.management.repository.ChargesRepository;
import com.hms.management.repository.RadiologyReportRepository;
import com.hms.management.serviceimpl.RadiologyReportServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("radiologyreport")
public class RadiologyReportController {

	
	
	
	public String UPLOADED_FOLDER="";
	
	
	@Autowired
	public RadiologyReportServiceImpl radiologyReportServiceImpl;
	
	@Autowired
	public RadiologyReportRepository radiologyReportRepository;
	
	
	@Autowired
	public ChargesRepository chargesRepository;
	
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
	public RadiologyReport addRadiologyReport(@RequestBody RadiologyReport radiologyReport) throws ParseException {
		return radiologyReportServiceImpl.addRadiologyReport(radiologyReport);
		}
	
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces ="application/json")
	public List<RadiologyReport> getAllRadiologyReport(){
		return radiologyReportServiceImpl.getAllRadiologyReport();
		
	}
	public Map<String, Object> deleteRadiologyReport(@PathVariable int id){
		return radiologyReportServiceImpl.deleteRadiologyReport(id);
		
	}
	
	@CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object addPatientRegistration(RadiologyReportBean radiologyReportBean) throws RecordNotFoundException, ParseException {
		//Map<String,Object> map=new HashMap<String, Object>();
		List<Map<String,Object>> al=new ArrayList<>();
		RadiologyReport n=new RadiologyReport();
        byte[] bytes = null;
		try {
			bytes = radiologyReportBean.getRadiologyReport().getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + radiologyReportBean.getRadiologyReport().getOriginalFilename());
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setRadiologyReport(UPLOADED_FOLDER + radiologyReportBean.getRadiologyReport().getOriginalFilename());
  
	       // n.setPhoto(UPLOADED_FOLDER + patientRegistrationBean.getPhoto().getOriginalFilename());
	     //  n.setPatientId("P-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
	     Map<String, Object> map=new HashMap<>();
            Date d=new Date();
	        n.setUpdatedAt(d);
	        n.setCreatedAt(d);
            n.setBillNo(radiologyReportBean.getBillNo());
            n.setReportingDate(d);
            n.setConsultantDoctor(radiologyReportBean.getConsultantDoctor());
            n.setCreatedAt(radiologyReportBean.getCreatedAt());
            n.setDescription(radiologyReportBean.getDescription());
            n.setPatientName(radiologyReportBean.getPatientName());
            n.setApplyCharge(radiologyReportBean.getApplyCharge());
           // List<Charges> ch=chargesRepository.findByOpdId(radiologyReportBean.getPatientId());
           // if(ch.size()!=0) {
           // 	for(Charges b:ch) {
            //		b.getStandardCharge();
            //		b.getCode();
            //		b.getChargeCategory();
			return radiologyReportServiceImpl.addRadiologyReport(n);
            	    
           }
	
	@RequestMapping(value = "updateradiologyreport",method = RequestMethod.PUT,produces = "application/json")
	public Object updateRadiologyReport(@RequestBody RadiologyReport radiologyReport) {
		return radiologyReportServiceImpl.updateRadiologyReport(radiologyReport);
		
	}
	
	//get last seven days records
	@RequestMapping(value = "/lastsevndaysrecord",method = RequestMethod.GET)
	public Object getByReportDate() {
 		return radiologyReportServiceImpl.getByReportDate();
		
	}
	
	//get current month records
	@RequestMapping(value = "/currentmonthrecord",method = RequestMethod.GET)
	public Object getCurrentMonthRecords() {
 		return radiologyReportServiceImpl.getCurrentMontReport();
		
	}
	//get current year records
	@RequestMapping(value = "/currentyearrecord",method = RequestMethod.GET)
	public Object getCurrentYearRecords() {
 		return radiologyReportServiceImpl.getCurrentYearReport();
		
	}

	//get last three month records
	@RequestMapping(value = "/lastthreemonthrecords",method = RequestMethod.GET)
	public Object getLastThreeMonthRecords() {
 		return radiologyReportServiceImpl.getLastThreeMonthRecords();
	 }

	//get last six month records
	@RequestMapping(value = "/lastsixmonthrecords",method = RequestMethod.GET)
	public Object getLastSixMonthRecords() {
 		return radiologyReportServiceImpl.getLastSixtMonthRecords();
	 }

	//get last nine month records
	@RequestMapping(value = "/lastninemonthrecords",method = RequestMethod.GET)
	public Object getLastNineMonthRecords() {
 		return radiologyReportServiceImpl.getLastNineMonthRecords();
	 }

	//get last twelve month records
	@RequestMapping(value = "/lasttwelvemonthrecords",method = RequestMethod.GET)
	public Object getLastTwelveMonthRecords() {
 		return radiologyReportServiceImpl.getLastTwelveMonthRecords();
	 }
	//get any year records
	@RequestMapping(value = "/anyyear/{reportingDate}",method = RequestMethod.GET)
	public Object getAnyYearRecords(Date reportingDate) {
 		return radiologyReportServiceImpl.getAnyYearRecords(reportingDate);
	 }

}
