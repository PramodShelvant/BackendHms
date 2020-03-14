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

import com.hms.management.beans.FinanceExpensesBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.FinanceExpenses;
import com.hms.management.serviceimpl.FinanceExpensesServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/financeexpense")
public class FinanceExpensesController {
	
	
	
	private static String UPLOADED_FOLDER = "//home//madarsha//Desktop//D//";

	@Autowired
	public FinanceExpensesServiceImpl financeExpensesServiceImpl;
	
	  @CrossOrigin
      @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object addFinanceExpenses(FinanceExpensesBean financeExpensesBean) throws RecordNotFoundException {
		Map<String,Object> map=new HashMap<String, Object>();
 		FinanceExpenses n=new FinanceExpenses();
        byte[] bytes = null;
		try {
			bytes = financeExpensesBean.getDocuments().getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + financeExpensesBean.getDocuments().getOriginalFilename());
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        n.setDocuments(UPLOADED_FOLDER + financeExpensesBean.getDocuments().getOriginalFilename());
        n.setName(financeExpensesBean.getName());
        n.setInvoiceNo(financeExpensesBean.getInvoiceNo());
        n.setDate(financeExpensesBean.getDate());
        n.setAmount(financeExpensesBean.getAmount());
        n.setNote(financeExpensesBean.getNote());
        n.setIsActive(financeExpensesBean.getIsActive());
        n.setIsDeleted(financeExpensesBean.getIsDeleted());
        
         
        FinanceExpenses fine=financeExpensesServiceImpl.addFinanceExpenses(n);
        map.put("data saved", new ResponseEntity<FinanceExpenses>(fine, new HttpHeaders(), HttpStatus.OK));
		return map;
	}

      @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
      public FinanceExpenses getFinanceExpensesById(@PathVariable int id) throws RecordNotFoundException {
   		return financeExpensesServiceImpl.getFinanceExpenses(id);
      }
      
      @CrossOrigin
  	@RequestMapping(value = {"","receptionist/{id}","admin/{id}"}, method = RequestMethod.GET, produces = "application/json")
      public List<FinanceExpenses> getFinanceExpensesAll() throws RecordNotFoundException {
   		return financeExpensesServiceImpl.getAllFinanceExpenses();
      }
      @CrossOrigin
  	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  	public Object deleteFinanceExpenses(@PathVariable int id) {
  		return financeExpensesServiceImpl.deleteFinanceExpenses(id);
  		
  	} 
      
      @CrossOrigin
      @RequestMapping(value = "/iffileisnull",method = RequestMethod.POST,produces = "application/json")
      public FinanceExpenses adFinanceExpense(@RequestBody FinanceExpenses financeExpence) {
		return financeExpensesServiceImpl.adFinanceExpenses(financeExpence);
    	  
      }
      
      
}
