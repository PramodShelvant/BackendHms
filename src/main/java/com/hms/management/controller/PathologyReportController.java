package com.hms.management.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.model.PathologyReport;
import com.hms.management.serviceimpl.PathologyReportServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("pathologyreport/")
public class PathologyReportController {

	
	
	@Autowired
	public PathologyReportServiceImpl pathologyReportServiceImpl;
	
	
	@RequestMapping(value = "", method = RequestMethod.POST,produces = "application/json")
	public PathologyReport addPathologyReport(@RequestBody PathologyReport pathologyReport) {
		return pathologyReportServiceImpl.addPathologyReport(pathologyReport);
		
	}
	
	@RequestMapping(value = "ppp/{patientId}",method = {RequestMethod.GET},produces = "application/json")
	public Object getAllPathologyReport(@PathVariable String patientId){
		return pathologyReportServiceImpl.getAllTestReports(patientId);
		
	}
	
	@GetMapping(value = "year/{reportingDate}")
	public Object getAnyYearRecords(@PathVariable Date reportingDate) {
		return pathologyReportServiceImpl.getAnyYearRecords(reportingDate);
		
	}
	
	
	//Starting from 1st Jan of the current Year till now.
   @GetMapping(value = "currentyeartillnow/{reportingDate}")
    public Object getCurrentYearTillNow(@PathVariable("reportingDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date reportingDate) {
		return pathologyReportServiceImpl
		.getCurrentYearTillNow(reportingDate);
	}
   
	//Starting from 1st date of the current month till now.
   @GetMapping(value = "getCurrentMonthRecordTillNow/{reportingDate}")
    public Object getCurrentMonthRecordTillNow(@PathVariable("reportingDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date reportingDate) {
		return pathologyReportServiceImpl
		.getCurrentMonthRecordTillNow(reportingDate);
	}
   
   @GetMapping(value = "getLastSixMonthRecordTillNow/{reportingDate}")
   public Object getLastSixMonthRecordTillNow(@PathVariable("reportingDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date reportingDate) {
		return pathologyReportServiceImpl
		.getLastSixMonthRecordTillNow(reportingDate);
	}

   @GetMapping(value = "getLastSevenDaysRecord/{reportingDate}")
   public Object getLastSevenDaysRecord(@PathVariable("reportingDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date reportingDate) {
		return pathologyReportServiceImpl.getLastSevenDaysRecord(reportingDate);
	}
   
   @GetMapping(value = "getLastThreeMonthsRecord")
   public Object getLastThreeMonthsRecord() {
		return pathologyReportServiceImpl.getLastThreeMonthsRecord();
	}
   
   @GetMapping(value = "getLastNinthMonthsRecord")
   public Object getLastNinthMonthsRecord() {
		return pathologyReportServiceImpl.getLastNinthMonthsRecord();
	}
   
   @GetMapping(value = "getLastTwelveMonthsRecord")
   public Object getLastTwelveMonthsRecord() {
		return pathologyReportServiceImpl.getLastTwelveMonthsRecord();
	}
   
   @GetMapping(value = "getLastOneMonthsRecord")
   public Object getLastOneMonthsRecord() {
		return pathologyReportServiceImpl.getLastOneMonthsRecord();
	}

}
