package com.hms.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.model.Charges;
import com.hms.management.repository.ChargesRepository;
import com.hms.management.service.ChargesService;

@Service
public class ChargesServiceImpl implements ChargesService{

	
	
	@Autowired
	public ChargesRepository chargesRepository;

	@Override
	public Charges addCharges(Charges charges) {
 		return chargesRepository.save(charges);
	}
    @Override
	public Object getCharges(String opdId) {
//    	Map<String, Object> map=new HashMap<>();
//    	List<Charges> al=chargesRepository.findByOpdId(opdId);
//    	if(al.size()!=0) {
//    		Charges a=al.get(0);
//    		map.put
//     	}
		return chargesRepository.findByOpdId(opdId);
	}
    @Override
    public List<Charges> getAll(){
		return chargesRepository.findAll();
    	
    }
}
