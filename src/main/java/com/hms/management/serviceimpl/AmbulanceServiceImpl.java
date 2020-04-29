package com.hms.management.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.Ambulance;
import com.hms.management.repository.AmbulanceRepository;
import com.hms.management.service.AmbulanceService;

@Service
public class AmbulanceServiceImpl implements AmbulanceService{

	
	@Autowired
	public AmbulanceRepository ambulanceRepository;

	@Override
	public Ambulance addAmbulance(Ambulance ambulance) {
 		return ambulanceRepository.save(ambulance);
	}

	@Override
	public List<Ambulance> getAll() {
 		return ambulanceRepository.findAll();
	}

	
	@Override
	public Object updateAmbulance(Ambulance ambulance) {
		Map<String, Object> map=new HashMap<>();
		Optional<Ambulance> al=ambulanceRepository.findById(ambulance.getId());
		if(al.isPresent()) {
			Ambulance d=al.get();
			if(ambulance.getDriverContact()!=null) {
				d.setDriverContact(ambulance.getDriverContact());}
			if(ambulance.getDriverLicence()!=null) {
				d.setDriverLicence(ambulance.getDriverLicence());}
			if(ambulance.getDriverName()!=null) {
				d.setDriverName(ambulance.getDriverName());}
			if(ambulance.getManufactureYear()!=null) {
				d.setManufactureYear(ambulance.getManufactureYear());}
			if(ambulance.getNote()!=null) {
				d.setNote(ambulance.getNote());}
			if(ambulance.getVehicleModel()!=null) {
				d.setVehicleModel(ambulance.getVehicleModel());}
			if(ambulance.getVehicleNo()!=null) {
				d.setVehicleNo(ambulance.getVehicleNo());}
			if(ambulance.getVehicleType()!=null) {
				d.setVehicleType(ambulance.getVehicleType());}
			if(ambulance.getUpdatedAt()!=null) {
				d.setUpdatedAt(ambulance.getUpdatedAt());}
			if(ambulance.getCreatedAt()!=null) {
				d.setCreatedAt(ambulance.getCreatedAt());
	        map.put("updated data", ambulanceRepository.save(d));
		   return map;
	     }else    {
	    	map.put("updated data", "id not found for update");
	    	return map;
	    	}
		}
		return map;
	}
	
	
	@Override
	public Object deleteAmbulance(int id) {
		Map<String, Object> map=new HashMap<String, Object>();
		ambulanceRepository.deleteById(id);
		map.put("status",1);
 		return map;
	}
}
