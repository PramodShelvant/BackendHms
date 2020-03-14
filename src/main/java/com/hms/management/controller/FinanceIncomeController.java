package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.beans.FinanceIncomeBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.FinanceIncome;
import com.hms.management.serviceimpl.FinanceIncomeServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/financeincome")
public class FinanceIncomeController {

	
	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//D//";

	@Autowired
	public FinanceIncomeServiceImpl financeIncomeServiceImpl;
		
	
	@CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object addVisitors(FinanceIncomeBean financeIncomeBean) throws RecordNotFoundException {
		Map<String,Object> map=new HashMap<String, Object>();
 		FinanceIncome n=new FinanceIncome();
        byte[] bytes = null;
		try {
			bytes = financeIncomeBean.getDocuments().getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + financeIncomeBean.getDocuments().getOriginalFilename());
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setDocuments(UPLOADED_FOLDER + financeIncomeBean.getDocuments().getOriginalFilename());
        n.setName(financeIncomeBean.getName());
        n.setInvoiceNo(financeIncomeBean.getInvoiceNo());
         
        FinanceIncome fine=financeIncomeServiceImpl.addfinanace(n);
        map.put("data saved", new ResponseEntity<FinanceIncome>(fine, new HttpHeaders(), HttpStatus.OK));
		return map;
	}

    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> getAll(@PathVariable int id) throws RecordNotFoundException {
		Map<String,Object> map=new HashMap<String,Object>();
		FinanceIncome updated= financeIncomeServiceImpl.getFinanceIncome(id);
		map.put("details of financeincome bills",new ResponseEntity<FinanceIncome>(updated, new HttpHeaders(), HttpStatus.OK));
		return map;
    }
	@CrossOrigin
    @RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public List<FinanceIncome> getAllDeathRecord() throws RecordNotFoundException {
 		return financeIncomeServiceImpl.getAllFinanceIncome();
    }
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteFinanceIncome(@PathVariable int id) {
		return financeIncomeServiceImpl.deleteFinanceIncome(id);
		
	}
	
	
	@RequestMapping(value = "iffileisnull",method = RequestMethod.POST,produces = "application/json")
	public FinanceIncome adFinanceIncome(@RequestBody FinanceIncome financeIncome) {
		return financeIncomeServiceImpl.adfinanceIncome(financeIncome);
		
	}
}
