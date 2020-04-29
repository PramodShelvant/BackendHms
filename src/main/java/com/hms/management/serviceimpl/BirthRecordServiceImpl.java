package com.hms.management.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.BirthRecord;
import com.hms.management.repository.BirthRecordRepository;
import com.hms.management.service.BirthRecordService;
@Service

public class BirthRecordServiceImpl implements BirthRecordService{

	
	@Autowired
	public BirthRecordRepository birthRecordRepository;

	@Override
	public BirthRecord addBirthRecord(BirthRecord BirthRecord) throws RecordNotFoundException {
 		return birthRecordRepository.save(BirthRecord);
	}

	@Override
	public BirthRecord getBirthRecord(int id) throws RecordNotFoundException {
 		return birthRecordRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No birthrecord record exist for given id"));
	}
	
	

	@Override
	public List<BirthRecord> getAllBirthRecord() throws RecordNotFoundException {
 		return birthRecordRepository.findAll();
	}

	@Override
	public Object deleteBirthRecord(int id) {
		Map<String, Object> map=new HashMap<>();
		birthRecordRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

	
	@Override
	public BirthRecord adBirthRecord(BirthRecord birthRecord) {
 		return birthRecordRepository.save(birthRecord);
	}

	
	
	//last seven days records
	public Object getLastSevenDaysReport() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findAllLastSevenDaysReport();
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;
	}

	public Object getCurrentYearReports() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findAllCurrentYearReport();
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

 	}

	public Object getCurrentMonthReports() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findAllCurrentMonthReport();
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

 	}

	public Object getLastThreeMonthsRecords() {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findAllLastThreeMonthReport();
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

 	}

	public Object getLastSixMonthReports() {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findAllLastSixMonthReport();
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

 	}

	public Object getLastTwelveMonthReports() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findAllLastTwelveMonthReport();
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

 	}

	public Object OneMonthRecordTillNow() {
		

		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findAllOneMonthReport();
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

	}

	public Object getThisYearNextYearLastYear(String birthDate) {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findByBirthDateLike(birthDate);
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

 	}

	public Object getAllByBirthDate(String birthDate) {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findByBirthDate(birthDate);
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

		
  	}

	public Object getBetweenDatesRecords(String birthDate, String birthDate1) {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findByBirthDateBetween(birthDate,birthDate1);
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

 	}
	//SELECT * FROM items WHERE created_at > DATE_SUB(NOW(), INTERVAL 1 WEEK);

	public Object getThisWeek() {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();

		List<BirthRecord> br=birthRecordRepository.findAllByThisWeek();
		if(br.size()!=0) {
			for(BirthRecord b:br) {
		 		new HashMap<>();
                map.put("ipdOrOpdNo", b.getIpdOrOpdNo());
				map.put("motherName", b.getMotherName());
				map.put("fatherName", b.getFatherName());
				map.put("childName", b.getChildName());
				map.put("birthDate", b.getBirthDate());
				map.put("weight", b.getWeight());
				result.add(map);
				}
		}else {
			map.put("msg",  "no records");
			result.add(map);

		}
 		return result;

 		
	}
}
