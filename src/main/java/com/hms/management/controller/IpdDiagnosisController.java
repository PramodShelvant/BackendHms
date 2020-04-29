package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.IpdDiagnosisBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.IpdDiagnosis;
import com.hms.management.serviceimpl.IpdDiagnosisServiceImpl;
@CrossOrigin()
@RestController
@RequestMapping("ipddiagnosis")
public class IpdDiagnosisController {

	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//D//";

	
	
	@Autowired
	public IpdDiagnosisServiceImpl ipdDiagnosisServiceImpl;
	
    @CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public IpdDiagnosis addIpdDiagnosis(IpdDiagnosisBean ipdDiagnosisBean) throws RecordNotFoundException {
		IpdDiagnosis n=new IpdDiagnosis();
		System.out.println(n);
		System.out.println(ipdDiagnosisBean);
		if(ipdDiagnosisBean.getDocument()!=null) {
	        byte[] bytes = null;
			try {
				bytes = ipdDiagnosisBean.getDocument().getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
	        Path path = Paths.get(UPLOADED_FOLDER + ipdDiagnosisBean.getDocument().getOriginalFilename());
	        try {
				Files.write(path, bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        n.setDocument(UPLOADED_FOLDER + ipdDiagnosisBean.getDocument().getOriginalFilename());
 			 n.setDescription(ipdDiagnosisBean.getDescription());
			// n.setId(opdDiagnosisBean.getId());
			 n.setPatientId(ipdDiagnosisBean.getPatientId());
			 n.setReportDate(ipdDiagnosisBean.getReportDate());
			 n.setReportType(ipdDiagnosisBean.getReportType());
			}else {
				 n.setDocument(null);
				 n.setDescription(ipdDiagnosisBean.getDescription());
					// n.setId(opdDiagnosisBean.getId());
					 n.setPatientId(ipdDiagnosisBean.getPatientId());
					 n.setReportDate(ipdDiagnosisBean.getReportDate());
					 n.setReportType(ipdDiagnosisBean.getReportType());
				 }
		return ipdDiagnosisServiceImpl.addIpdDiagnosis(n);
    }
    
    @CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public IpdDiagnosis getIpdDaignosis(@PathVariable int id) throws RecordNotFoundException {
		return ipdDiagnosisServiceImpl.getIpdDiagnosis(id);
    	
    }
    
    @RequestMapping(value = "iffileisnull",method = RequestMethod.POST,produces = "application/json")
    public IpdDiagnosis adIpdDiagnosis(@RequestBody IpdDiagnosis ipdDiagnosis) {
		return ipdDiagnosisServiceImpl.adIpdDiagnosis(ipdDiagnosis);
    	
    }
}
