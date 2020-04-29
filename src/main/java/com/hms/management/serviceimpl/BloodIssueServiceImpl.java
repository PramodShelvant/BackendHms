package com.hms.management.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BloodIssue;
import com.hms.management.repository.BloodIssueRepository;
import com.hms.management.service.BloodIssueService;
@Service
public class BloodIssueServiceImpl implements BloodIssueService{

	
	@Autowired
	public BloodIssueRepository bloodIssueRepository;

	@Override
	public BloodIssue addBloodIssue(BloodIssue BloodIssue) {
		Date d=new Date();
		BloodIssue.setDateOfIssue(d);
		BloodIssue.setUpdatedAt(d);
		BloodIssue.setCreatedAt(d);
 		return bloodIssueRepository.save(BloodIssue);
	}
	
	@Override
	public BloodIssue getBloodIssue(int id) throws RecordNotFoundException {
 		return bloodIssueRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no BloodIssue records for this id"));
	}

	@Override
	public List<BloodIssue> getAllBloodIssue() throws RecordNotFoundException {
 		return bloodIssueRepository.findAll();
	}

	@Override
	public Object deleteBloodIssue(int id) {
		Map<String, Object> map=new HashMap<>();
		bloodIssueRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
	
	@Override
	public Object GetByDoctorName(String doctor) {
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAll();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				map.put("doctor", b.getDoctor());
			}
 		}else{
			map.put("msg", "doctors names are not found");
		}
		return map;
		}
	
	
	@Override
	public Object getByDonorName(String donorName) {
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAll();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				map.put("donorName", b.getDonorName());
			}
 		}else{
			map.put("msg", "DonorName names are not found");
		}
		return map;
		
	}

	public Object getCurrentMonthReposrt() {
		List<Map<String, Object>> result= new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAllCurrentMontReport();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				
				map.put("bagNo", b.getBagNo());
				map.put("donorName", b.getDonorName());
				map.put("bloodGroup", b.getBloodGroup());
 				map.put("gender", b.getGender());
				map.put("recieveTo", b.getRecieveTo());
				map.put("amount", b.getAmount());
				map.put("lot", b.getLot());
				map.put("dateOfIssue", b.getDateOfIssue());
				result.add(map);
			}
		}else {
			map.put("msg","no records found for current month");
			result.add(map);

		}
 		return result;
	}
	
	public Object getCurrentYearReposrt() {
		List<Map<String, Object>> result= new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAllCurrentYearReport();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				
				map.put("bagNo", b.getBagNo());
				map.put("donorName", b.getDonorName());
				map.put("bloodGroup", b.getBloodGroup());
 				map.put("gender", b.getGender());
				map.put("recieveTo", b.getRecieveTo());
				map.put("amount", b.getAmount());
				map.put("lot", b.getLot());
				map.put("dateOfIssue", b.getDateOfIssue());
				result.add(map);
			}
		}else {
			map.put("msg","no records found for current year");
			result.add(map);

		}
 		return result;
	}

	public Object getLastSevenDaysReport() {
		List<Map<String, Object>> result= new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAllLastsevenDaysReport();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				
				map.put("bagNo", b.getBagNo());
				map.put("donorName", b.getDonorName());
				map.put("bloodGroup", b.getBloodGroup());
 				map.put("gender", b.getGender());
				map.put("recieveTo", b.getRecieveTo());
				map.put("amount", b.getAmount());
				map.put("lot", b.getLot());
				map.put("dateOfIssue", b.getDateOfIssue());
				result.add(map);
			}
		}else {
			map.put("msg","no records found for current year");
			result.add(map);

		}
 		return result;
	}

	public Object getLastThreeMonthsReports() {
		List<Map<String, Object>> result= new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAllLatThreeMonthsReports();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				
				map.put("bagNo", b.getBagNo());
				map.put("donorName", b.getDonorName());
				map.put("bloodGroup", b.getBloodGroup());
 				map.put("gender", b.getGender());
				map.put("recieveTo", b.getRecieveTo());
				map.put("amount", b.getAmount());
				map.put("lot", b.getLot());
				map.put("dateOfIssue", b.getDateOfIssue());
				result.add(map);
			}
		}else {
			map.put("msg","no records found for last three months ");
			result.add(map);

		}
 		return result;
	}

	public Object getLastSixMonthReports() {
		List<Map<String, Object>> result= new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAllLastSixMonthReports();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				
				map.put("bagNo", b.getBagNo());
				map.put("donorName", b.getDonorName());
				map.put("bloodGroup", b.getBloodGroup());
 				map.put("gender", b.getGender());
				map.put("recieveTo", b.getRecieveTo());
				map.put("amount", b.getAmount());
				map.put("lot", b.getLot());
				map.put("dateOfIssue", b.getDateOfIssue());
				result.add(map);
			}
		}else {
			map.put("msg","no records found for last six months ");
			result.add(map);

		}
 		return result;
	}

	public Object getLastNineMonthsReports() {
		List<Map<String, Object>> result= new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAllLastNineMonthReports();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				
				map.put("bagNo", b.getBagNo());
				map.put("donorName", b.getDonorName());
				map.put("bloodGroup", b.getBloodGroup());
 				map.put("gender", b.getGender());
				map.put("recieveTo", b.getRecieveTo());
				map.put("amount", b.getAmount());
				map.put("lot", b.getLot());
				map.put("dateOfIssue", b.getDateOfIssue());
				result.add(map);
			}
		}else {
			map.put("msg","no records found for last six months ");
			result.add(map);

		}
 		return result;
	}

	public Object getLateTwelveMonthsReports() {
		List<Map<String, Object>> result= new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAllLasttwelveMonthReports();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				
				map.put("bagNo", b.getBagNo());
				map.put("donorName", b.getDonorName());
				map.put("bloodGroup", b.getBloodGroup());
 				map.put("gender", b.getGender());
				map.put("recieveTo", b.getRecieveTo());
				map.put("amount", b.getAmount());
				map.put("lot", b.getLot());
				map.put("dateOfIssue", b.getDateOfIssue());
				result.add(map);
			}
		}else {
			map.put("msg","no records found for last six months ");
			result.add(map);

		}
 		return result;
	}

	public Object getlastMont() {
		List<Map<String, Object>> result= new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<BloodIssue> bl=bloodIssueRepository.findAllLastMonth();
		if(bl.size()!=0) {
			for(BloodIssue b:bl) {
				
				map.put("bagNo", b.getBagNo());
				map.put("donorName", b.getDonorName());
				map.put("bloodGroup", b.getBloodGroup());
 				map.put("gender", b.getGender());
				map.put("recieveTo", b.getRecieveTo());
				map.put("amount", b.getAmount());
				map.put("lot", b.getLot());
				map.put("dateOfIssue", b.getDateOfIssue());
				result.add(map);
			}
		}else {
			map.put("msg","no records found for last months ");
			result.add(map);

		}
 		return result;
	}
}
