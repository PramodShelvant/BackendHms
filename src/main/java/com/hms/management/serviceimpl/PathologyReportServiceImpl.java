package com.hms.management.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.PathologyReport;
import com.hms.management.repository.PathologyReportRepository;
import com.hms.management.repository.PathologyRepository;
import com.hms.management.service.PathologyReportSevice;

@Service
public class PathologyReportServiceImpl implements PathologyReportSevice{

	
	@Autowired
	public PathologyReportRepository pathologyReportRepository;

	
	@Autowired
	public PathologyRepository pathologyRepository;
	
	
	@Override
	public PathologyReport addPathologyReport(PathologyReport pathologyReport) {
		 //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 //Date date = new Date();
		// System.out.println(dateFormat.format(date));

		Date d=new Date();
		pathologyReport.setUpdatedAt(d);
		pathologyReport.setCreatedAt(d);
		pathologyReport.setReportingDate(d);
 		return pathologyReportRepository.save(pathologyReport);
	}

	@Override
	public Object getAllTestReports(String patientId) {
		List<Map<String, Object>> result=new ArrayList<>();

		Map<String, Object> map=new HashMap<>();
		PathologyReport k=pathologyReportRepository.findByPatientId(patientId);

		if(k!=null) {
			//for(PathologyReport k
				new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("applyCharge", k.getAction());
				result.add(map);
			}else {
					map.put("msg", "no data found for given pathology id");
					}
		return map;
		}	
	 	
 	public Object getLastOneMonthRecord() {
		Map<String, Object> map=new HashMap<>();
		List<PathologyReport> al=pathologyReportRepository.findAll();
		if(al.size()!=0) {
			for(PathologyReport k:al) {
				new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				
			}

 				}else {
 					map.put("msg", "no data found for given reportingDate");
 				}
		return map;
			
		}
 	
	
	@Override
	public Object getAnyYearRecords(Date reportingDate) {
		List<Map<String, Object>> result=new ArrayList<>();
 		Map<String, Object> map=new HashMap<>();

		List<PathologyReport> al=pathologyReportRepository.findByReportingDateLike(reportingDate);
		System.out.println("pathologyReportRepository----->"+al);
           if(al.size()!=0) {
			//PathologyReport o=al.get(0);
			for(PathologyReport k:al) {
		 		new HashMap<>();

			    map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("testName", k.getPathology().getTestName());
				map.put("shortName", k.getPathology().getShortName());
				map.put("standardCharge", k.getPathology().getStandardCharge());
 				result.add(map);
			}
		}else {
			map.put("msg", "no records found for this year");
			return map;
		}
		return result;
 		
		}
	
	//Starting from 1st Jan of the current Year till now.
     public Object getCurrentYearTillNow(Date reportingDate) {
		List<Map<String, Object>> result=new ArrayList<>();
 		Map<String, Object> map=new HashMap<>();

        List<PathologyReport> al=pathologyReportRepository.findByAllReportingDate(reportingDate);
		System.out.println("pathologyReportRepository----->"+al);
           if(al.size()!=0) {
 			for(PathologyReport k:al) {
		 		new HashMap<>();

			    map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("testName", k.getPathology().getTestName());
				map.put("shortName", k.getPathology().getShortName());
				map.put("standardCharge", k.getPathology().getStandardCharge());
 				result.add(map);
  				}
		}else {
			map.put("msg", "no records found current Year till now");
			return map;
		}
		return result;
 		
		}
//current month record till now
     //SELECT * FROM `dt_table` WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()
     public Object getCurrentMonthRecordTillNow(Date reportingDate) {
		List<Map<String, Object>> result=new ArrayList<>();
 		Map<String, Object> map=new HashMap<>();

        List<PathologyReport> al=pathologyReportRepository.findByAllReportingDateMonthRec(reportingDate);
		System.out.println("pathologyReportRepository----->"+al);
           if(al.size()!=0) {
 			for(PathologyReport k:al) {
		 		new HashMap<>();

			    map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("testName", k.getPathology().getTestName());
				map.put("shortName", k.getPathology().getShortName());
				map.put("standardCharge", k.getPathology().getStandardCharge());
 				result.add(map);
  				}
		}else {
			map.put("msg", "no records found current month till now");
			return map;
		}
		return result;
     }

     //last six month record till date
     //SELECT * FROM dt_table WHERE `date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 10 DAY ) AND CURDATE()
     public Object getLastSixMonthRecordTillNow(Date reportingDate) {
		List<Map<String, Object>> result=new ArrayList<>();
 		Map<String, Object> map=new HashMap<>();

        List<PathologyReport> al=pathologyReportRepository.findByAllReportingDateSixMonthRec(reportingDate);
            if(al.size()!=0) {
 			for(PathologyReport k:al) {
		 		new HashMap<>();

			    map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("testName", k.getPathology().getTestName());
				map.put("shortName", k.getPathology().getShortName());
				map.put("standardCharge", k.getPathology().getStandardCharge());
 				result.add(map);
  					
  				}
		}else {
			map.put("msg", "no records found current month till now");
			return map;
		}
		return result;

     }

	public Object getLastSevenDaysRecord(Date reportingDate) {
		List<Map<String, Object>> result=new ArrayList<>();
 		Map<String, Object> map=new HashMap<>();
 		List<PathologyReport> al=pathologyReportRepository.findByReportingDateLastSevenDaysRec(reportingDate);
         if(al.size()!=0) {
			for(PathologyReport k:al) {
		 		new HashMap<>();

			    map.put("billNo", k.getBillNo());
				map.put("patientName", k.getPatientName());
				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("testName", k.getPathology().getTestName());
				map.put("shortName", k.getPathology().getShortName());
				map.put("standardCharge", k.getPathology().getStandardCharge());
 				result.add(map);
  			}
		}else {
			map.put("msg", "no records found current last 7 days");
			return map;
		}

		return result;
	}

	//last three months records
	public Object getLastThreeMonthsRecord() {
		List<Map<String, Object>> result=new ArrayList<>();
 		Map<String, Object> map=new HashMap<>();
 		List<PathologyReport> al=pathologyReportRepository.findByAllReportingDateThreeMonthRec();
         if(al.size()!=0) {
			for(PathologyReport k:al) {
		 		new HashMap<>();

			    map.put("billNo", k.getBillNo());
				map.put("patientName", k.getPatientName());
				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("testName", k.getPathology().getTestName());
				map.put("shortName", k.getPathology().getShortName());
				map.put("standardCharge", k.getPathology().getStandardCharge());
 				result.add(map);

   				}
		}else {
			map.put("msg", "no records found last three months");
			return map;
		}

		return result;

	}

	public Object getLastNinthMonthsRecord() {
		List<Map<String, Object>> result=new ArrayList<>();
 		Map<String, Object> map=new HashMap<>();
 		List<PathologyReport> al=pathologyReportRepository.findByAllReportingDateNineMonthRec();
         if(al.size()!=0) {
			for(PathologyReport k:al) {
		 		new HashMap<>();

			    map.put("billNo", k.getBillNo());
				map.put("patientName", k.getPatientName());
				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("testName", k.getPathology().getTestName());
				map.put("shortName", k.getPathology().getShortName());
				map.put("standardCharge", k.getPathology().getStandardCharge());
 				result.add(map);
   				}
		}else {
			map.put("msg", "no records found last nine months");
			return map;
		}

		return result;
	}

	public Object getLastTwelveMonthsRecord() {
		List<Map<String, Object>> result=new ArrayList<>();
 		Map<String, Object> map=new HashMap<>();
 		List<PathologyReport> al=pathologyReportRepository.findByAllReportingDateNineTwelveMonthsRec();
         if(al.size()!=0) {
			for(PathologyReport k:al) {
		 		new HashMap<>();

			    map.put("billNo", k.getBillNo());
				map.put("patientName", k.getPatientName());
				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
				map.put("testName", k.getPathology().getTestName());
				map.put("shortName", k.getPathology().getShortName());
				map.put("standardCharge", k.getPathology().getStandardCharge());
 				result.add(map);

   				}
		}else {
			map.put("msg", "no records found last twelve months");
			return map;
		}

		return result;
	}

	public Object getLastOneMonthsRecord() {
 			List<Map<String, Object>> result=new ArrayList<>();
	 		Map<String, Object> map=new HashMap<>();
	 		List<PathologyReport> al=pathologyReportRepository.findByAllReportingDateLastOneMonthsRec();
	         if(al.size()!=0) {
				for(PathologyReport k:al) {
			 		new HashMap<>();

				    map.put("billNo", k.getBillNo());
					map.put("patientName", k.getPatientName());
					map.put("reportDate", k.getReportingDate());
 					map.put("consulttantDoctor", k.getConsultantDoctor());
					map.put("description", k.getDescription());
					map.put("applyCharge", k.getApplyCharge());
					map.put("testName", k.getPathology().getTestName());
					map.put("shortName", k.getPathology().getShortName());
					map.put("standardCharge", k.getPathology().getStandardCharge());
	 				result.add(map);

 	  				}
			}else {
				map.put("msg", "no records found last twelve months");
				return map;
			}

			return result;
	}
}

