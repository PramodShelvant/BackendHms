package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.MedicianBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Medician;
import com.hms.management.serviceimpl.MedicianServiceImpl;
@CrossOrigin
@RequestMapping("medician")
@RestController
public class MedicianController {


	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//D//";

	@Autowired
	public MedicianServiceImpl medicianServiceImpl;
	@CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object addMedician(MedicianBean medicianBean) throws RecordNotFoundException {
		//Map<String,Object> map=new HashMap<String, Object>();
		Medician n=new Medician();
        byte[] bytes = null;
		try {
			bytes = medicianBean.getMedicinePhoto().getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + medicianBean.getMedicinePhoto().getOriginalFilename());
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setMedicinePhoto(UPLOADED_FOLDER + medicianBean.getMedicinePhoto().getOriginalFilename());
        n.setMedicineName(medicianBean.getMedicineName());
        n.setMedicineCategory(medicianBean.getMedicineCategory());
        n.setMedicineCompany(medicianBean.getMedicineCompany());
        n.setMedicineComposition(medicianBean.getMedicineComposition());
        n.setMedicineGroup(medicianBean.getMedicineGroup());
        n.setUnit(medicianBean.getUnit());
        n.setMinLevel(medicianBean.getMinLevel());
        n.setReOrderLevel(medicianBean.getReOrderLevel());
        n.setVat(medicianBean.getVat());
        n.setVatAc(medicianBean.getVatAc());
        n.setPacking(medicianBean.getPacking());
        n.setNote(medicianBean.getNote());
 		return medicianServiceImpl.addMedician(n);
    }
	@CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Medician getMedicianById(@PathVariable int id) throws RecordNotFoundException {
 		return medicianServiceImpl.getMedician(id);
    }
    @CrossOrigin
	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<Medician> getAllMedicians() throws RecordNotFoundException {
 		return medicianServiceImpl.getAllMedician();
    }
    
    @CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteMedician(@PathVariable int id) {
		return medicianServiceImpl.deleteMedician(id);
		
	}
    
    
    @CrossOrigin
    @RequestMapping(value ="iffileisnull",method = RequestMethod.POST,produces = "application/json")
    public Medician adMedician(@RequestBody Medician medician) {
		return medicianServiceImpl.adMedician(medician);
    	
    }
}
