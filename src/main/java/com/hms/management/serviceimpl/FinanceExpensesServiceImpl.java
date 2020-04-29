package com.hms.management.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.FinanceExpenses;
import com.hms.management.repository.FinanceExpensesRepository;
import com.hms.management.service.FinanceExpensesService;

@Service
public class FinanceExpensesServiceImpl implements FinanceExpensesService{

	@Autowired
	public FinanceExpensesRepository financeExpensesRepository;

	public FinanceExpenses addFinanceExpenses(FinanceExpenses financeExpenses) {
		Date d=new Date();
		financeExpenses.setUpdatedAt(d);
		financeExpenses.setCreatedAt(d);
 		return financeExpensesRepository.save(financeExpenses);
	}

	@Override
	public FinanceExpenses getFinanceExpenses(int id) throws RecordNotFoundException {
 		return financeExpensesRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no FinanceExpenses records for this id"));
	}

	@Override
	public List<FinanceExpenses> getAllFinanceExpenses() throws RecordNotFoundException {
 		return financeExpensesRepository.findAll();
	}

	@Override
	public Object deleteFinanceExpenses(int id) {
		Map<String, Object> map=new HashMap<>();
		financeExpensesRepository.deleteById(id);
		map.put("status", 1);
 		return map;
	}

	@Override
	public FinanceExpenses adFinanceExpenses(FinanceExpenses financeExpence) {
 		return financeExpensesRepository.save(financeExpence);
	}

	public Object getByDate(Date date) {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<FinanceExpenses> ex=financeExpensesRepository.findByDate(date);
			if(ex.size()!=0) {
				for(FinanceExpenses f:ex) {
					Map<String, Object> map=new HashMap<>();
					map.put("expCategory", f.getExpenseHead().getExpCategory());
					map.put("amount", f.getAmount());
					map.put("expCategory", f.getName());
					map.put("expCategory", f.getInvoiceNo());
					map.put("expCategory", f.getDate());
					map.put("id", f.getExpenseHead().getId());

					result.add(map);
				}
			}else {
				mapQ.put("msg", "no records found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
 	}

	public Object getLastSevenDaysReport() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<FinanceExpenses> ex=financeExpensesRepository.findAllLastSevenDaysRec();
			if(ex.size()!=0) {
				for(FinanceExpenses f:ex) {
					Map<String, Object> map=new HashMap<>();
					map.put("expCategory", f.getExpenseHead().getExpCategory());
					map.put("amount", f.getAmount());
					map.put("expCategory", f.getName());
					map.put("expCategory", f.getInvoiceNo());
					map.put("expCategory", f.getDate());
					map.put("id", f.getExpenseHead().getId());

					result.add(map);
				}
			}else {
				mapQ.put("msg", "no records found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public Object getCurrentMonthRecords() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<FinanceExpenses> ex=financeExpensesRepository.findAllCurrentMonthRecordsDaysRec();
			if(ex.size()!=0) {
				for(FinanceExpenses f:ex) {
					Map<String, Object> map=new HashMap<>();
					map.put("expCategory", f.getExpenseHead().getExpCategory());
					map.put("amount", f.getAmount());
					map.put("expCategory", f.getName());
					map.put("expCategory", f.getInvoiceNo());
					map.put("expCategory", f.getDate());
					map.put("id", f.getExpenseHead().getId());

					result.add(map);
				}
			}else {
				mapQ.put("msg", "no records found");
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
			List<FinanceExpenses> ex=financeExpensesRepository.findAllCurrentYearRecordsDaysRec();
			if(ex.size()!=0) {
				for(FinanceExpenses f:ex) {
					Map<String, Object> map=new HashMap<>();
					map.put("expCategory", f.getExpenseHead().getExpCategory());
					map.put("amount", f.getAmount());
					map.put("id", f.getExpenseHead().getId());
					map.put("expCategory", f.getName());
					map.put("expCategory", f.getInvoiceNo());
					map.put("expCategory", f.getDate());
					result.add(map);
				}
			}else {
				mapQ.put("msg", "no records found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;	
	}

	public Object getLastThreeMonthsReports() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<FinanceExpenses> ex=financeExpensesRepository.findAllLastThreeRecordsDaysRec();
			if(ex.size()!=0) {
				for(FinanceExpenses f:ex) {
					Map<String, Object> map=new HashMap<>();
					map.put("expCategory", f.getExpenseHead().getExpCategory());
					map.put("id", f.getExpenseHead().getId());
					map.put("amount", f.getAmount());
					map.put("expCategory", f.getName());
					map.put("expCategory", f.getInvoiceNo());
					map.put("expCategory", f.getDate());
					result.add(map);
				}
			}else {
				mapQ.put("msg", "no records found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;	


	}

	public Object getLastSixMonthRecords() {
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<FinanceExpenses> ex=financeExpensesRepository.findAllLastSixMonthRecordsDaysRec();
			if(ex.size()!=0) {
				for(FinanceExpenses f:ex) {
					Map<String, Object> map=new HashMap<>();
					map.put("expCategory", f.getExpenseHead().getExpCategory());
					map.put("id", f.getExpenseHead().getId());
                    map.put("amount", f.getAmount());
					map.put("expCategory", f.getName());
					map.put("expCategory", f.getInvoiceNo());
					map.put("expCategory", f.getDate());
					result.add(map);
				}
			}else {
				mapQ.put("msg", "no records found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;	

 	}

	public Object getLastTwelveMonthRecords() {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<FinanceExpenses> ex=financeExpensesRepository.findAllLastTwelveMonthRecordsDaysRec();
			if(ex.size()!=0) {
				for(FinanceExpenses f:ex) {
					Map<String, Object> map=new HashMap<>();
					map.put("expCategory", f.getExpenseHead().getExpCategory());
					map.put("id", f.getExpenseHead().getId());
					map.put("amount", f.getAmount());
					map.put("expCategory", f.getName());
					map.put("expCategory", f.getInvoiceNo());
					map.put("expCategory", f.getDate());
					result.add(map);
				}
			}else {
				mapQ.put("msg", "no records found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;	

	}

	public Object getAll() {
		
		
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<FinanceExpenses> ex=financeExpensesRepository.findAll();
			if(ex.size()!=0) {
				for(FinanceExpenses f:ex) {
					Map<String, Object> map=new HashMap<>();
					map.put("expCategory", f.getExpenseHead().getExpCategory());
					map.put("id", f.getExpenseHead().getId());
					map.put("amount", f.getAmount());
					map.put("expCategory", f.getName());
					map.put("expCategory", f.getInvoiceNo());
					map.put("expCategory", f.getDate());
					result.add(map);
				}
			}else {
				mapQ.put("msg", "no records found");
				result.add(mapQ);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;	


	}

	 
}
