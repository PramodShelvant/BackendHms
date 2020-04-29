package com.hms.management.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.AmbulanceCall;
import com.hms.management.repository.AmbulanceCallRepository;
import com.hms.management.service.AmbulanceCallService;

@Service
public class AmbulanceCallServiceImpl implements AmbulanceCallService{

	
	
	@Autowired
	public AmbulanceCallRepository ambulanceCallRepository;
	@Override
	public AmbulanceCall addAmbulanceCall(AmbulanceCall ambulanceCall) {
		Date d=new Date();
 		ambulanceCall.setUpdatedAt(d);
 		ambulanceCall.setCreatedAt(d);
 		return ambulanceCallRepository.save(ambulanceCall);
	}
	public AmbulanceCall getAmbulanceCall(int id) throws RecordNotFoundException {
 		return ambulanceCallRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No ambulance record exist for given id"));
	}
	@Override
	public List<AmbulanceCall> getAllAmbulanve() throws RecordNotFoundException {
 		return ambulanceCallRepository.findAll();
	}
	@Override
	public Object deleteAmbulanceCall(int id) {
		Map<String, Object> map=new HashMap<String, Object>();
		ambulanceCallRepository.deleteById(id);
		map.put("status",1);
 		return map;
	}
	
	@Override
	public Object updateAmbulance(AmbulanceCall ambulanceCall) {
		Map<String, Object> map=new HashMap<>();
		Optional<AmbulanceCall> al=ambulanceCallRepository.findById(ambulanceCall.getId());
		if(al.isPresent()) {
			AmbulanceCall d=al.get();
			if(ambulanceCall.getAddress()!=null) {
				d.setAddress(ambulanceCall.getAddress());}
			if(ambulanceCall.getAmount()!=0.0) {
				d.setAmount(ambulanceCall.getAmount());}
			if(ambulanceCall.getContactNo()!=null) {
				d.setContactNo(ambulanceCall.getContactNo());}
			if(ambulanceCall.getDate()!=null) {
				d.setDate(ambulanceCall.getDate());}
			if(ambulanceCall.getDriver()!=null) {
				d.setDriver(ambulanceCall.getDriver());}
			if(ambulanceCall.getPatienName()!=null) {
				d.setPatienName(ambulanceCall.getPatienName());}
			if(ambulanceCall.getVehicleModel()!=null) {
				d.setVehicleModel(ambulanceCall.getVehicleModel());}
			if(ambulanceCall.getVehicleNo()!=null) {
				d.setVehicleNo(ambulanceCall.getVehicleNo());
			    Date p=new Date();
			     d.setUpdatedAt(p);}
			map.put("updated data", ambulanceCallRepository.save(d));
			return map;
		}else {
			map.put("updated data", "id not found for update");
			return map;

		}
 	}
	
	@Override
	public Object  getByPatientName(String patienName) {
		
		Map<String, Object>  map=new HashMap<>();
		AmbulanceCall am=ambulanceCallRepository.findByPatienName(patienName);
		if(am!=null) {
			map.put("address", am.getAddress());
			map.put("amount", am.getAmount());
			map.put("contactNo", am.getContactNo());
			map.put("createdAt", am.getCreatedAt());
			map.put("date", am.getDate());
			map.put("driver", am.getDriver());
 			map.put("patientName", am.getPatienName());
			map.put("updatedAt", am.getUpdatedAt());
			map.put("vehicleModel", am.getVehicleModel());
			map.put("vehicleNo", am.getVehicleNo());
			}else {
				map.put("msg", "no records found for last sevan days");
				
			}
 		return map;
	}
	public Object getLastSevenDaysReport() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
		List<AmbulanceCall> m=ambulanceCallRepository.findAllLastsevenDaysRecords();

		if(m.size()!=0) {
		for(AmbulanceCall am:m) {
			map.put("address", am.getAddress());
			map.put("amount", am.getAmount());
			map.put("contactNo", am.getContactNo());
 			map.put("date", am.getDate());
			map.put("driver", am.getDriver());
  			map.put("vehicleModel", am.getVehicleModel());
			map.put("vehicleNo", am.getVehicleNo());
			result.add(map);
		     }
			}else {
				map.put("msg", "no records found on patientId");
				return map;
				}
 		return result;
	}
	public Object getCurrentmonthRecord() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
		List<AmbulanceCall> m=ambulanceCallRepository.findAllCurrentMonthRecords();

		if(m.size()!=0) {
		for(AmbulanceCall am:m) {
			map.put("address", am.getAddress());
			map.put("amount", am.getAmount());
			map.put("contactNo", am.getContactNo());
 			map.put("date", am.getDate());
			map.put("driver", am.getDriver());
  			map.put("vehicleModel", am.getVehicleModel());
			map.put("vehicleNo", am.getVehicleNo());
			result.add(map);
		     }
			}else {
				map.put("msg", "no records found on patientId");
				return map;
				}
 		return result;
	}
	public Object getCurrentYear() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
		List<AmbulanceCall> m=ambulanceCallRepository.findAllCurrentYearReports();

		if(m.size()!=0) {
		for(AmbulanceCall am:m) {
			map.put("address", am.getAddress());
			map.put("amount", am.getAmount());
			map.put("contactNo", am.getContactNo());
 			map.put("date", am.getDate());
			map.put("driver", am.getDriver());
  			map.put("vehicleModel", am.getVehicleModel());
			map.put("vehicleNo", am.getVehicleNo());
			result.add(map);
		     }
			}else {
				map.put("msg", "no records found on patientId");
				return map;
				}
 		return result;
	}
	public Object getThreeMonth() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
		List<AmbulanceCall> m=ambulanceCallRepository.findAllThreeMonthsRecords();

		if(m.size()!=0) {
		for(AmbulanceCall am:m) {
			map.put("address", am.getAddress());
			map.put("amount", am.getAmount());
			map.put("contactNo", am.getContactNo());
 			map.put("date", am.getDate());
			map.put("driver", am.getDriver());
  			map.put("vehicleModel", am.getVehicleModel());
			map.put("vehicleNo", am.getVehicleNo());
			result.add(map);
		     }
			}else {
				map.put("msg", "no records found on patientId");
				return map;
				}
 		return result;
	}
	public Object getSixMonth() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
		List<AmbulanceCall> m=ambulanceCallRepository.findAllSixMonthsRecords();

		if(m.size()!=0) {
		for(AmbulanceCall am:m) {
			map.put("address", am.getAddress());
			map.put("amount", am.getAmount());
			map.put("contactNo", am.getContactNo());
 			map.put("date", am.getDate());
			map.put("driver", am.getDriver());
  			map.put("vehicleModel", am.getVehicleModel());
			map.put("vehicleNo", am.getVehicleNo());
			result.add(map);
		     }
			}else {
				map.put("msg", "no records found on patientId");
				return map;
				}
 		return result;
	}
	public Object getTweveMonth() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object>  map=new HashMap<>();
		List<AmbulanceCall> m=ambulanceCallRepository.findAllTwelveMonthsRecords();

		if(m.size()!=0) {
		for(AmbulanceCall am:m) {
			map.put("address", am.getAddress());
			map.put("amount", am.getAmount());
			map.put("contactNo", am.getContactNo());
 			map.put("date", am.getDate());
			map.put("driver", am.getDriver());
  			map.put("vehicleModel", am.getVehicleModel());
			map.put("vehicleNo", am.getVehicleNo());
			result.add(map);
		     }
			}else {
				map.put("msg", "no records found on patientId");
				return map;
				}
 		return result;
	}
	 
	 
}
