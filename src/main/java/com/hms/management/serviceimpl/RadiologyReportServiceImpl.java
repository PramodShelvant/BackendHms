package com.hms.management.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hms.management.model.PathologyReport;
import com.hms.management.model.RadiologyReport;
import com.hms.management.repository.RadiologyReportRepository;
import com.hms.management.repository.RediologyRepository;
import com.hms.management.service.RadiologyReportService;

@Service
public class RadiologyReportServiceImpl implements RadiologyReportService{

	
	
	@Autowired
	public RadiologyReportRepository radiologyReportRepository;
	
	
	@Autowired
	public RediologyRepository rediologyRepository;
	
	
	@Override
	public RadiologyReport addRadiologyReport(RadiologyReport radiologyReport) throws ParseException {
		SimpleDateFormat formatter=new SimpleDateFormat("YYYY-MM-DD");
		Date d=new Date();
		Date todayWithOutTime =formatter.parse(formatter.format(d));
		radiologyReport.setUpdatedAt(d);
		radiologyReport.setCreatedAt(d);
		radiologyReport.setReportingDate(todayWithOutTime);
 		return radiologyReportRepository.save(radiologyReport);
	}

	@Override
	public List<RadiologyReport> getAllRadiologyReport() {
 		return radiologyReportRepository.findAll();
	}

	@Override
	public Map<String, Object> deleteRadiologyReport(int id) {
		Map<String, Object> map=new HashMap<>();
		radiologyReportRepository.deleteById(id);
		map.put("1", "status");
 		return map;
	}

	@Override
	public Object updateRadiologyReport(@RequestBody RadiologyReport radiologyReport) {
		Optional<RadiologyReport> g=radiologyReportRepository.findByBillNo(radiologyReport.getBillNo());
		Map<String, Object> map=new HashMap<>();
		if(g.isPresent()) {
			RadiologyReport t=g.get();
 			//t.setBillNo(radiologyReport.getBillNo());
			if(t.getApplyCharge()!=0.0) {
				t.setApplyCharge(radiologyReport.getApplyCharge());}
			if(t.getConsultantDoctor()!=null) {
				t.setConsultantDoctor(radiologyReport.getConsultantDoctor());}
			if(t.getCreatedAt()!=null) {
				t.setCreatedAt(radiologyReport.getCreatedAt());}
			if(t.getCustomerType()!=null) {
				t.setCustomerType(radiologyReport.getCustomerType());}
			if(t.getDescription()!=null) {
				t.setDescription(radiologyReport.getDescription());}
			if(t.getPatientId()!=null) {
				t.setPatientId(radiologyReport.getPatientId());}
			if(t.getPatientName()!=null) {
				t.setPatientName(radiologyReport.getPatientName());}
 			if(t.getRadiologyReport()!=null) {
				t.setRadiologyReport(radiologyReport.getRadiologyReport());}
			if(t.getReportingDate()!=null) {
					t.setReportingDate(radiologyReport.getReportingDate());}
			if(t.getUpdatedAt()!=null) {
				t.setUpdatedAt(radiologyReport.getUpdatedAt());}
			map.put("updated date", radiologyReportRepository.save(t));
 		}
		return map;
  	}
	
	public Object getAllTestReports(String patientId) {
		Map<String, Object> map=new HashMap<>();
		List<PathologyReport> al=radiologyReportRepository.findByPatientId(patientId);
		if(al.size()!=0) {
			for(PathologyReport k:al) {
				new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
				//map.put("pathologiId", k.getPathologyId());
				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
				map.put("applyCharge", k.getApplyCharge());
 
				/*
				 * String pathalogy=k.getPathologyId(); Pathology
				 * pp=rediologyRepository.findByPathologyId(k.getPathologyId()); if(pp!=null) {
				 * map.put("testName", pp.getTestName()); map.put("shortName",
				 * pp.getShortName()); map.put("chargeCategory", pp.getStandardCharge());
				 * 
				 * }else { map.put("msg", "no data found for given pathology id"); }
				 */			}
		}else {
			map.put("msg", "no data found for given pathology id");
			}
		return map;
 	}
 
	
	
	public Object getAllReportingDateTestReports(Date reportingDate) {
		Map<String, Object> map=new HashMap<>();
		List<RadiologyReport> al=radiologyReportRepository.findByReportingDate(reportingDate);
		if(al.size()!=0) {
			for(RadiologyReport k:al) {
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

	//last seven days records
	public Object getByReportDate() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<RadiologyReport> rd=radiologyReportRepository.findByAllReportingDateLatSevenDays();
		System.out.println(rd);
		if(rd.size()!=0) {
			for(RadiologyReport k:rd) {
			    map=new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
 				map.put("chargeCategory", k.getRadiology().getChargeCategory());
				map.put("standardCharge", k.getRadiology().getStandardCharge());
 				result.add(map);

				}
		}else {
			map.put("msg","no records found for last seven days");
			}
		return result;

	}
	
	//get current month records
	public Object getCurrentMontReport() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<RadiologyReport> rd=radiologyReportRepository.findByAllGetCurrentMontReport();
		System.out.println(rd);
		if(rd.size()!=0) {
			for(RadiologyReport k:rd) {
			    map=new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
 				map.put("chargeCategory", k.getRadiology().getChargeCategory());
				map.put("standardCharge", k.getRadiology().getStandardCharge());
 				result.add(map);

				}
		}else {
			map.put("msg","no records found for last seven days");
			}
		return result;

	}

	public Object getCurrentYearReport() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<RadiologyReport> rd=radiologyReportRepository.findByAllGetCurrentYearReport();
		System.out.println(rd);
		if(rd.size()!=0) {
			for(RadiologyReport k:rd) {
			    map=new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
 				map.put("chargeCategory", k.getRadiology().getChargeCategory());
				map.put("standardCharge", k.getRadiology().getStandardCharge());
 				result.add(map);

				}
		}else {
			map.put("msg","no records found for last seven days");
			}
		return result;
	}

	public Object getLastThreeMonthRecords() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<RadiologyReport> rd=radiologyReportRepository.findByLastThreeMonthsReport();
		System.out.println(rd);
		if(rd.size()!=0) {
			for(RadiologyReport k:rd) {
			    map=new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
 				map.put("chargeCategory", k.getRadiology().getChargeCategory());
				map.put("standardCharge", k.getRadiology().getStandardCharge());
 				result.add(map);

				}
		}else {
			map.put("msg","no records found for last seven days");
			}
		return result;
	}

	public Object getLastSixtMonthRecords() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<RadiologyReport> rd=radiologyReportRepository.findByLastSixMonthsReport();
		System.out.println(rd);
		if(rd.size()!=0) {
			for(RadiologyReport k:rd) {
			    map=new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
 				map.put("chargeCategory", k.getRadiology().getChargeCategory());
				map.put("standardCharge", k.getRadiology().getStandardCharge());
 				result.add(map);

				}
		}else {
			map.put("msg","no records found for last seven days");
			}
		return result;
	}

	public Object getLastNineMonthRecords() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<RadiologyReport> rd=radiologyReportRepository.findByLastNineMonthsReport();
		System.out.println(rd);
		if(rd.size()!=0) {
			for(RadiologyReport k:rd) {
			    map=new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
 				map.put("chargeCategory", k.getRadiology().getChargeCategory());
				map.put("standardCharge", k.getRadiology().getStandardCharge());
 				result.add(map);

				}
		}else {
			map.put("msg","no records found for last ninemonth records");
			}
		return result;
	}

	//last twelve month records
	public Object getLastTwelveMonthRecords() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<RadiologyReport> rd=radiologyReportRepository.findByLastTwelveMonthsReport();
		System.out.println(rd);
		if(rd.size()!=0) {
			for(RadiologyReport k:rd) {
			    map=new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
 				map.put("chargeCategory", k.getRadiology().getChargeCategory());
				map.put("standardCharge", k.getRadiology().getStandardCharge());
 				result.add(map);

				}
		}else {
			map.put("msg","no records found for last ninemonth records");
			}
		return result;
	}

	public Object getAnyYearRecords(Date reportingDate) {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<RadiologyReport> rd=radiologyReportRepository.findAnyYearRecord(reportingDate);
		System.out.println(rd);
		if(rd.size()!=0) {
			for(RadiologyReport k:rd) {
			    map=new HashMap<>();
				map.put("billNo", k.getBillNo());
  				map.put("patientName", k.getPatientName());
 				map.put("reportDate", k.getReportingDate());
 				map.put("consulttantDoctor", k.getConsultantDoctor());
				map.put("description", k.getDescription());
 				map.put("chargeCategory", k.getRadiology().getChargeCategory());
				map.put("standardCharge", k.getRadiology().getStandardCharge());
 				result.add(map);

				}
		}else {
			map.put("msg","no records found for last ninemonth records");
			}
		return result;
	}

}
