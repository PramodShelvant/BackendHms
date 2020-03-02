package com.hms.management.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Pathology;
import com.hms.management.repository.PathologyRepository;
import com.hms.management.service.PathologyService;

@Service
public class PathologyServiceImpl implements PathologyService{

	@Autowired
	public PathologyRepository pathologyRepository;

	@Override
	public Pathology addPathology(Pathology pathology) throws RecordNotFoundException {
         Date d=new Date();	
        pathology.setCreatedAt(d);
        pathology.setUpdatedAt(d);
         return pathologyRepository.save(pathology);
	}

	@Override
	public Pathology getPathology(int id) throws RecordNotFoundException {
        Optional<Pathology> p = pathologyRepository.findById(id);
          if(p.isPresent()) {
            return p.get();
        } else {
            throw new RecordNotFoundException("No Pathology record exist for given id");
        }
	}
	@Override
	public List<Pathology> getAllPathology() {
 		return pathologyRepository.findAll();
	}
	@Override
	public Pathology getByPatientid(String patientId) {
 		return pathologyRepository.findByPatientId(patientId);
	}

	@Override
	public Object deletePathology(int id) {
		Map<String, Object> map=new HashMap<String, Object>();
		pathologyRepository.deleteById(id);
		map.put("Status", 1);
 		return map;
	}
}
