package com.hms.management.service;

import java.util.Date;

import com.hms.management.model.PathologyReport;

public interface PathologyReportSevice {

	
	public PathologyReport addPathologyReport(PathologyReport pathologyReport);
	public Object getAllTestReports(String patientId);
 	public Object getAnyYearRecords(Date reportingDate);
 	
}
