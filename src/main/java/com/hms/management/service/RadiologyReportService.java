package com.hms.management.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.hms.management.model.RadiologyReport;

public interface RadiologyReportService {

	public RadiologyReport addRadiologyReport(RadiologyReport radiologyReport) throws ParseException;
	public List<RadiologyReport>  getAllRadiologyReport();
	public Map<String, Object> deleteRadiologyReport(int id);
	public Object updateRadiologyReport(RadiologyReport radiologyReport);
 }
