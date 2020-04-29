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
import com.hms.management.model.BloodDonor;
import com.hms.management.repository.BloodDonorCycleRepository;
import com.hms.management.repository.BloodDonorRepository;
import com.hms.management.service.BloodDonorService;

@Service
public class BloodDonorServiceImpl implements BloodDonorService{

	
	@Autowired
	public BloodDonorRepository bloodDonorRepository;
	
	
	@Autowired
	public BloodDonorCycleRepository bloodDonorCycleRepository;

	@Override
	public BloodDonor addBloodDonor(BloodDonor bloodDonor) {
		Date d=new Date();
		bloodDonor.setUpdatedAt(d);
		bloodDonor.setCreatedAt(d);
 		return bloodDonorRepository.save(bloodDonor);
	}

	@Override
	public BloodDonor getBloodDonor(int id) throws RecordNotFoundException {
 		return bloodDonorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("no BloodDonor records for this id"));
	}

	@Override
	public List<BloodDonor> getAllBloodDonor() throws RecordNotFoundException {
 		return bloodDonorRepository.findAll();
	}

	@Override
	public Object deleteBloodDonor(int id) {
		Map<String, Object> map=new HashMap<>();
		bloodDonorRepository.deleteById(id);
		map.put("status", 1);
		return map;
	}

	@Override
	public Object updateBloodDonor(BloodDonor bloodDonor) {
		Map<String, Object> map=new HashMap<>();
		Optional<BloodDonor> al=bloodDonorRepository.findById(bloodDonor.getId());
		if(al.isPresent()) {
			BloodDonor bl=al.get();
			if(bl.getAddress()!=null) {
				bl.setAddress(bloodDonor.getAddress());}
			if(bl.getAge()!=null) {
				bl.setAge(bloodDonor.getAge());}
			if(bl.getBloodGroup()!=null) {
				bl.setBloodGroup(bloodDonor.getBloodGroup());}
			if(bl.getContactNo()!=null) {
				bl.setContactNo(bloodDonor.getContactNo());}
			if(bl.getCreatedAt()!=null) {
				bl.setCreatedAt(bloodDonor.getCreatedAt());}
			if(bl.getDonorName()!=null) {
				bl.setDonorName(bloodDonor.getDonorName());}
			if(bl.getGender()!=null) {
				bl.setGender(bloodDonor.getGender());}
			if(bl.getId()!=0) {
				bl.setId(bloodDonor.getId());}
			if(bl.getMonth()!=null) {
				bl.setMonth(bloodDonor.getMonth());}
			if(bl.getUpdatedAt()!=null) {
				bl.setUpdatedAt(bloodDonor.getUpdatedAt());}
                map.put("updated data", bloodDonorRepository.save(bl));
                return map;
		    }else {
                map.put("msg", "appointment status not found");
         		return map ;
            }
      }
	
	@Override
	public Object getBloodDonorByBloodGroup(String bloodGroup){
		Map<String, Object> map=new HashMap<>();
		List<BloodDonor> g=bloodDonorRepository.findByBloodGroup(bloodGroup);
		if(g.size()!=0) {
			for(BloodDonor b:g) {
				map.put("bloodGroup", b.getBloodGroup());
				map.put("status(in bags)", g.size());
			}
		}
		return map;
	}

	@Override
	public Object adBloodDonor(BloodDonor bloodDonor) {
		Map<String, Object> map=new HashMap<>();
		Date d=new Date();
		BloodDonor b=bloodDonorRepository.findByDonorName(bloodDonor.getDonorName());
		if(b!=null) {
			bloodDonor.setUpdatedAt(d);
			bloodDonor.setCreatedAt(d);

			map.put("saved data", bloodDonorRepository.save(bloodDonor));
		}else {
			map.put("msg","donorName is not found");
			}
		return map;
		}
	
	@Override
	public Object getBybloodDonorId(String bloodDonorId) {
		Map<String, Object> map=new HashMap<>();
		BloodDonor bl=bloodDonorRepository.findByBloodDonorId(bloodDonorId);
		if(bl!=null) {
			map.put("address", bl.getAddress());
			map.put("age", bl.getAge());
			map.put("bloodDonorId", bl.getBloodDonorId());
			map.put("bloodGroup", bl.getBloodGroup());
			map.put("contactNo", bl.getContactNo());
			map.put("createdAt", bl.getCreatedAt());
			map.put("donorName", bl.getDonorName());
			map.put("gender", bl.getGender());
			map.put("month", bl.getMonth());
			map.put("updatedAt", bl.getUpdatedAt());
			map.put("action", bl.getInstitution().getAction());
			map.put("bagNo", bl.getInstitution().getBagNo());
			map.put("lot", bl.getInstitution().getLot());
			map.put("donateDate", bl.getInstitution().getDonatedDate());
			map.put("instituteId", bl.getInstitution().getInstuteId());
			map.put("quantity", bl.getInstitution().getQuantity());
			map.put("createdAt", bl.getInstitution().getCreatedAt());
			map.put("updatedAt", bl.getInstitution().getUpdatedAt());
            }else {
				map.put("msg","no records found for given bloodDonorId");
            
		}
		return map;
}
	

	public Object getLastSevenDaysReport() {
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();
		try {
			List<BloodDonor> al=bloodDonorRepository.findAlllastsevenDaysReport();
			System.out.println(al);
	        if(al.size()!=0) {
				for(BloodDonor k:al) {
					System.out.println("donated date----"+k.getDonateDate());
			 		mapQ=new HashMap<>();
					mapQ.put("donorName", k.getDonateDate());
					mapQ.put("donorName", k.getDonorName());
					mapQ.put("age", k.getAge());
					mapQ.put("bloodGroup", k.getBloodGroup());
					mapQ.put("gender", k.getGender());
				mapQ.put("lot", k.getInstitution().getLot());
				mapQ.put("quantity", k.getInstitution().getQuantity());
				mapQ.put("donatedDate", k.getInstitution().getDonatedDate());
				result.add(mapQ);

					/*
					 * if(k.getInstitution().getBagNo().isEmpty()) { mapQ.put("bagNo", "null");
					 * }else { mapQ.put("bagNo", k.getInstitution().getBagNo()); }
					 * if(k.getInstitution().getQuantity().isEmpty()) { mapQ.put("quantity","null");
					 * 
					 * }else { mapQ.put("quantity", k.getInstitution().getQuantity());
					 * 
					 * }
					 */
					//mapQ.put("lot", k.getInstitution().getLot());
 					//mapQ.put("quantity", k.getInstitution().getQuantity());
					//map.put("", b.getInstitution().getDonatedDate());
	  				//result.add(map);/
	  			}
			}else {
				mapQ.put("msg", "no records found current last 7 days");
				return mapQ;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
      return result;
	}

	public Object getCurrentMonthReports() {
		
		List<Map<String, Object>>  result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<BloodDonor> bl=bloodDonorRepository.findAllCurrentMonthReports();
			if(bl.size()!=0) {
				for(BloodDonor b:bl) {
					Map<String, Object> map=new HashMap<>();

					map.put("donatedDate", b.getDonateDate());
					map.put("donorName", b.getDonorName());
					map.put("gender", b.getGender());
					map.put("bloodGroup", b.getBloodGroup());
					map.put("age", b.getAge());
                    map.put("lot", b.getInstitution().getLot());
					map.put("quantity", b.getInstitution().getQuantity());
					map.put("bagNo", b.getInstitution().getBagNo());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "records not found");
				result.add(mapQ);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return result;
	}

	public Object getCurrentYearReposrts() {
		List<Map<String, Object>>  result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<BloodDonor> bl=bloodDonorRepository.findAllCurrentYearReports();
			if(bl.size()!=0) {
				for(BloodDonor b:bl) {
					Map<String, Object> map=new HashMap<>();

					map.put("donatedDate", b.getDonateDate());
					map.put("donorName", b.getDonorName());
					map.put("gender", b.getGender());
					map.put("bloodGroup", b.getBloodGroup());
					map.put("age", b.getAge());
                    map.put("lot", b.getInstitution().getLot());
					map.put("quantity", b.getInstitution().getQuantity());
					map.put("bagNo", b.getInstitution().getBagNo());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "records not found");
				result.add(mapQ);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return result;
	}

	public Object getLastThreeMonthsReports() {
		List<Map<String, Object>>  result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<BloodDonor> bl=bloodDonorRepository.findAllCurrentThreeMonthsReports();
			if(bl.size()!=0) {
				for(BloodDonor b:bl) {
					Map<String, Object> map=new HashMap<>();

					map.put("donatedDate", b.getDonateDate());
					map.put("donorName", b.getDonorName());
					map.put("gender", b.getGender());
					map.put("bloodGroup", b.getBloodGroup());
					map.put("age", b.getAge());
                    map.put("lot", b.getInstitution().getLot());
					map.put("quantity", b.getInstitution().getQuantity());
					map.put("bagNo", b.getInstitution().getBagNo());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "records not found");
				result.add(mapQ);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return result;
	}

	public Object lastSixMonthRecords() {
		List<Map<String, Object>>  result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<BloodDonor> bl=bloodDonorRepository.findAllCurrentSixMonthsReports();
			if(bl.size()!=0) {
				for(BloodDonor b:bl) {
					Map<String, Object> map=new HashMap<>();

					map.put("donatedDate", b.getDonateDate());
					map.put("donorName", b.getDonorName());
					map.put("gender", b.getGender());
					map.put("bloodGroup", b.getBloodGroup());
					map.put("age", b.getAge());
                    map.put("lot", b.getInstitution().getLot());
					map.put("quantity", b.getInstitution().getQuantity());
					map.put("bagNo", b.getInstitution().getBagNo());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "records not found");
				result.add(mapQ);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return result;
	}

	public Object getLastTwelveMonthsRecords() {
		List<Map<String, Object>>  result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<BloodDonor> bl=bloodDonorRepository.findAllCurrentTwelveReports();
			if(bl.size()!=0) {
				for(BloodDonor b:bl) {
					Map<String, Object> map=new HashMap<>();

					map.put("donatedDate", b.getDonateDate());
					map.put("donorName", b.getDonorName());
					map.put("gender", b.getGender());
					map.put("bloodGroup", b.getBloodGroup());
					map.put("age", b.getAge());
                    map.put("lot", b.getInstitution().getLot());
					map.put("quantity", b.getInstitution().getQuantity());
					map.put("bagNo", b.getInstitution().getBagNo());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "records not found");
				result.add(mapQ);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return result;
	}

	public Object getByDonatedDate(Date donateDate) {
		List<Map<String, Object>>  result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<BloodDonor> bl=bloodDonorRepository.findByDonateDate(donateDate);
			if(bl.size()!=0) {
				for(BloodDonor b:bl) {
					Map<String, Object> map=new HashMap<>();

					map.put("donatedDate", b.getDonateDate());
					map.put("donorName", b.getDonorName());
					map.put("gender", b.getGender());
					map.put("bloodGroup", b.getBloodGroup());
					map.put("age", b.getAge());
                    map.put("lot", b.getInstitution().getLot());
					map.put("quantity", b.getInstitution().getQuantity());
					map.put("bagNo", b.getInstitution().getBagNo());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "records not found");
				result.add(mapQ);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return result;
	}

	public Object getLastMonthReports() {
		List<Map<String, Object>>  result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<BloodDonor> bl=bloodDonorRepository.findAllOmeMonthRecords();
			if(bl.size()!=0) {
				for(BloodDonor b:bl) {
					Map<String, Object> map=new HashMap<>();

					map.put("donatedDate", b.getDonateDate());
					map.put("donorName", b.getDonorName());
					map.put("gender", b.getGender());
					map.put("bloodGroup", b.getBloodGroup());
					map.put("age", b.getAge());
                    map.put("lot", b.getInstitution().getLot());
					map.put("quantity", b.getInstitution().getQuantity());
					map.put("bagNo", b.getInstitution().getBagNo());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "records not found");
				result.add(mapQ);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return result;
	}

	public Object getAllRecords() {
		List<Map<String, Object>>  result=new ArrayList<>();
		Map<String, Object> mapQ=new HashMap<>();

		try {
			List<BloodDonor> bl=bloodDonorRepository.findAll();
			if(bl.size()!=0) {
				for(BloodDonor b:bl) {
					Map<String, Object> map=new HashMap<>();

					map.put("donatedDate", b.getDonateDate());
					map.put("donorName", b.getDonorName());
					map.put("gender", b.getGender());
					map.put("bloodGroup", b.getBloodGroup());
					map.put("age", b.getAge());
                    map.put("lot", b.getInstitution().getLot());
					map.put("quantity", b.getInstitution().getQuantity());
					map.put("bagNo", b.getInstitution().getBagNo());
					result.add(map);
					}
			}else {
				mapQ.put("msg", "records not found");
				result.add(mapQ);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return result;
	}

 }










