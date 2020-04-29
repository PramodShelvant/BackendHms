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
import com.hms.management.model.FinanceIncome;
import com.hms.management.repository.FinanceIncomeRepository;
import com.hms.management.service.FinanceIncomeService;

@Service
public class FinanceIncomeServiceImpl implements FinanceIncomeService{

	
	@Autowired
	public FinanceIncomeRepository financeIncomeRepository;

	 

	@Override
	public FinanceIncome addfinanace(FinanceIncome financeIncome) throws RecordNotFoundException {
 				Date d=new Date();
				financeIncome.setCreatedAt(d);
				financeIncome.setUpdatedAt(d);
	            return financeIncomeRepository.save(financeIncome);
          
 	    
	}
	@Override
	public FinanceIncome getFinanceIncome(int id) throws RecordNotFoundException {
  		Optional<FinanceIncome> financeIncome=financeIncomeRepository.findById(id);
		if(financeIncome.isPresent()) {           
			return financeIncome.get();
        } else {
            throw new RecordNotFoundException("No FinanceIncome record exist for given id");
        }
	}
	public List<FinanceIncome> getAllFinanceIncome() {
 		return financeIncomeRepository.findAll();
	}
	
	@Override
	public Object deleteFinanceIncome(int id) {
		Map<String, Object> map=new HashMap<>();
		financeIncomeRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}
	
	@Override
	public FinanceIncome adfinanceIncome(FinanceIncome financeIncome) {
 		return financeIncomeRepository.save(financeIncome);
	}
	
	
	public Object getAll() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<FinanceIncome> fc=financeIncomeRepository.findAll();
			if(fc.size()!=0) {
				for(FinanceIncome f:fc) {
					Map<String, Object> map=new HashMap<>();
					map.put("incomeCategory", f.getIncomeHead().getIncomeCategory());
					map.put("date", f.getDate());
					map.put("invoiceNo", f.getInvoiceNo());
					map.put("name", f.getName());
					map.put("amount", f.getAmount());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "no record found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

 	}
	
	public Object getLastSevenDaysReports() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<FinanceIncome> fc=financeIncomeRepository.findAllLastSevenDaysReports();
			if(fc.size()!=0) {
				for(FinanceIncome f:fc) {
					Map<String, Object> map=new HashMap<>();
					map.put("incomeCategory", f.getIncomeHead().getIncomeCategory());
					map.put("date", f.getDate());
					map.put("invoiceNo", f.getInvoiceNo());
					map.put("name", f.getName());
					map.put("amount", f.getAmount());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "no record found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

	}
	public Object getCurrentYearReports() {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<FinanceIncome> fc=financeIncomeRepository.findAllCurrentYearReports();
			if(fc.size()!=0) {
				for(FinanceIncome f:fc) {
					Map<String, Object> map=new HashMap<>();
					map.put("incomeCategory", f.getIncomeHead().getIncomeCategory());
					map.put("date", f.getDate());
					map.put("invoiceNo", f.getInvoiceNo());
					map.put("name", f.getName());
					map.put("amount", f.getAmount());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "no record found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

  	}
	public Object getCurrentMonthReports() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<FinanceIncome> fc=financeIncomeRepository.findAllCurrentMonthReports();
			if(fc.size()!=0) {
				for(FinanceIncome f:fc) {
					Map<String, Object> map=new HashMap<>();
					map.put("incomeCategory", f.getIncomeHead().getIncomeCategory());
					map.put("date", f.getDate());
					map.put("invoiceNo", f.getInvoiceNo());
					map.put("name", f.getName());
					map.put("amount", f.getAmount());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "no record found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

 	}
	public Object getlastThreeMonthsreports() {
 
	
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<FinanceIncome> fc=financeIncomeRepository.findAllLastThreeMonthReports();
			if(fc.size()!=0) {
				for(FinanceIncome f:fc) {
					Map<String, Object> map=new HashMap<>();
					map.put("incomeCategory", f.getIncomeHead().getIncomeCategory());
					map.put("date", f.getDate());
					map.put("invoiceNo", f.getInvoiceNo());
					map.put("name", f.getName());
					map.put("amount", f.getAmount());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "no record found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

	}
	public Object getLastSixMonthReports() {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<FinanceIncome> fc=financeIncomeRepository.findAllLastSixMonthReports();
			if(fc.size()!=0) {
				for(FinanceIncome f:fc) {
					Map<String, Object> map=new HashMap<>();
					map.put("incomeCategory", f.getIncomeHead().getIncomeCategory());
 					map.put("date", f.getDate());
					map.put("invoiceNo", f.getInvoiceNo());
					map.put("name", f.getName());
					map.put("amount", f.getAmount());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "no record found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

 	}
	public Object getTwelveMonthsReports() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<FinanceIncome> fc=financeIncomeRepository.findAllLastTwelveMonthReports();
			if(fc.size()!=0) {
				for(FinanceIncome f:fc) {
					Map<String, Object> map=new HashMap<>();
					map.put("incomeCategory", f.getIncomeHead().getIncomeCategory());
					map.put("date", f.getDate());
					map.put("invoiceNo", f.getInvoiceNo());
					map.put("name", f.getName());
					map.put("amount", f.getAmount());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "no record found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

 	}
 	 

	public Object getByDate(Date date) {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<FinanceIncome> fc=financeIncomeRepository.findBydate(date);
			if(fc.size()!=0) {
				for(FinanceIncome f:fc) {
					Map<String, Object> map=new HashMap<>();
					map.put("incomeCategory", f.getIncomeHead().getIncomeCategory());
					map.put("date", f.getDate());
					map.put("invoiceNo", f.getInvoiceNo());
					map.put("name", f.getName());
					map.put("amount", f.getAmount());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "no record found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;


	}}
