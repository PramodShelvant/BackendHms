package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.OpdDiagnosisBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.OpdDiagnosis;
import com.hms.management.serviceimpl.OpdDiagnosisServiceImpl;

@RestController
@RequestMapping("opdDiagnosis")
public class OpdDiagnosisController {

	
	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//SPRING//";

	@Autowired
	public OpdDiagnosisServiceImpl opdDiagnosisServiceImpl; 
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public OpdDiagnosis addOpdDiagnosis(OpdDiagnosisBean opdDiagnosisBean) throws RecordNotFoundException {
		OpdDiagnosis n=new OpdDiagnosis();
		System.out.println(n);
		System.out.println(opdDiagnosisBean);
		if(opdDiagnosisBean.getDocument()!=null) {
	        byte[] bytes = null;
			try {
				bytes = opdDiagnosisBean.getDocument().getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
	        Path path = Paths.get(UPLOADED_FOLDER + opdDiagnosisBean.getDocument().getOriginalFilename());
	        try {
				Files.write(path, bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        n.setDocument(UPLOADED_FOLDER + opdDiagnosisBean.getDocument().getOriginalFilename());
 			 n.setDescription(opdDiagnosisBean.getDescription());
			// n.setId(opdDiagnosisBean.getId());
			 n.setPatientId(opdDiagnosisBean.getPatientId());
			 n.setReportDate(opdDiagnosisBean.getReportDate());
			 n.setReportType(opdDiagnosisBean.getReportType());
			}else {
				 n.setDocument(null);
				 n.setDescription(opdDiagnosisBean.getDescription());
					// n.setId(opdDiagnosisBean.getId());
					 n.setPatientId(opdDiagnosisBean.getPatientId());
					 n.setReportDate(opdDiagnosisBean.getReportDate());
					 n.setReportType(opdDiagnosisBean.getReportType());
				 }
		return opdDiagnosisServiceImpl.addOpdDiagnosis(n);
  	       }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public OpdDiagnosis getOpdDiagnosis(@PathVariable int id) throws RecordNotFoundException {
		return opdDiagnosisServiceImpl.getOpdDiagnosis(id);
	}
	
}
