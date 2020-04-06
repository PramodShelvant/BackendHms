package com.hms.management.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hms.management.EmailSender;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Appointment;
import com.hms.management.model.UserRegistration;
import com.hms.management.repository.AppointmentRepo;
import com.hms.management.repository.UserRegistrationRepository;
import com.hms.management.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	
	@Autowired
	AppointmentRepo appointmentRepo;

	
	@Autowired 
	public UserRegistrationRepository userRegistrationRepository;
	
	@Override
    public Object update(Appointment app) {
	return appointmentRepo.save(app);
}
	
	@Override
	public Object bookAppointment(Appointment appointment) throws RecordNotFoundException{
 		Date d=new Date();
 		UserRegistration u=new UserRegistration();
 		u.setEmail(appointment.getEmail());
 		u.setMobileNo(appointment.getMobileNumber());
 		u.setName(appointment.getPatientName());
 		//u.setPassword(appointment.get);
 		u.setGender(appointment.getGender());
 		u.setRole("patient");
 		u.setUserId("PAT-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
 		u.setPassword("12345");
 		//u.setPassword(PasswordGen.generateRandomPassword(7));
 		appointment.setAptId("APTID-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
        appointment.setCreatedAt(d);
		appointment.setUpdatedAt(d);
		appointment.setAppointmentStatus("pending");
 		UserRegistration u1=userRegistrationRepository.findByUserId(appointment.getPatientId());
		if(u1==null && appointment.getPatientId()!="") {
			Map map=new HashMap<>();
			map.put("err", "invalid patient Id");
			return map;
		}
		try {
  		if(appointment.getPatientId()=="" && userRegistrationRepository.save(u)!=null) {
		EmailSender.sendMail("revanhj1993@gmail.com", "sunday14031993", "userName:"+appointment.getEmail()+" password:12345", appointment.getEmail());
		
		return appointmentRepo.save(appointment);
		}
		}
		catch(Exception e) {
			Map map=new HashMap<>();
			map.put("err", "email already exist");
			return map;
		}
		List<Appointment> li=appointmentRepo.findByPatientId(appointment.getPatientId());
		if(li.size()>0) {
		Appointment app=li.get(0);
		appointment.setEmail(app.getEmail());
		appointment.setGender(app.getGender());
		appointment.setMobileNumber(app.getMobileNumber());
		appointment.setPatientName(app.getPatientName());
		//app.get
		
		}
			return appointmentRepo.save(appointment);
	}

	@Override
	public Appointment getAppointment(int id) throws RecordNotFoundException {
	 return appointmentRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("No appointment record exist for given id"));
	}

	@Override
	public List<Appointment> getAllAppointment() throws RecordNotFoundException {
 		return appointmentRepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}

	@Override
	public List<Map<String, Object>> getbookAppointment(String aptId) throws RecordNotFoundException {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Map<String, Object>> al=new ArrayList<Map<String, Object>>();
		//String aptId= appointment.getAptId();
 		     List<Appointment> a=appointmentRepo.findByAptId(aptId);
		     if(a.size()!=0) {
		    	 map.put("msg", a);
		    	 al.add(map);
 
		     }else {
		    	 map.put("msg", appointmentRepo.findAll());
		    	 al.add(map);
					return al;

		    	 }
			return al;
 	}

	@Override
	public List<Appointment> getPatientId(String patientId) throws RecordNotFoundException {
		//SimpleDateFormat formate=new SimpleDateFormat();
		
 		return appointmentRepo.findByPatientId(patientId);
	}

	@Override
	public List<Appointment> getByDoctorId(String doctorId) throws RecordNotFoundException {
 		return appointmentRepo.findByDoctorId(doctorId);
	}
	@Override
	public Object updateAppointmentByStatus(Appointment appointment) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Appointment> app=appointmentRepo.findByAppointmentStatus(appointment.getAppointmentStatus());
		if(app.size()!=0) {
			//Appointment pp=app.get();
			for(Appointment pp: app) {
            if(pp.getAppointmentStatus()!=null){
                pp.setAppointmentStatus(appointment.getAppointmentStatus());}
            
            if(pp.getAptId()!=null) {
            	pp.setAptId(appointment.getAptId());}
            if(pp.getCreatedAt()!=null) {
            	pp.setCreatedAt(appointment.getCreatedAt());}
            if(pp.getDate()!=null) {
            	pp.setDate(appointment.getDate());}
            if(pp.getDepartment()!=null) {
            	pp.setDepartment(appointment.getDepartment());}
            if(pp.getDoctorId()!=null) {
            	pp.setDoctorId(appointment.getDoctorId());}
            if(pp.getEmail()!=null) {
            	pp.setEmail(appointment.getEmail());}
            if(pp.getGender()!=null) {
            	pp.setGender(appointment.getGender());}
            if(pp.getId()!=0) {
            	pp.setId(appointment.getId());}
            if(pp.getMessage()!=null) {
            	pp.setMessage(appointment.getMessage());}
            if(pp.getMobileNumber()!=null) {
            	pp.setMobileNumber(appointment.getMobileNumber());}
            if(pp.getPatientId()!=null) {
            	pp.setPatientId(appointment.getPatientId());}
            if(pp.getPatientName()!=null) {
            	pp.setPatientName(appointment.getPatientName());}
            if(pp.getSource()!=null) {
            	pp.setSource(appointment.getSource());}
            if(pp.getUpdatedAt()!=null) {
            	pp.setUpdatedAt(appointment.getUpdatedAt());}
            if(pp.getUpdatedAt()!=null) {
            	pp.setUpdatedAt(appointment.getUpdatedAt());}
            if(pp.getCreatedAt()!=null) {
            	pp.setCreatedAt(appointment.getCreatedAt());}
            map.put("updated data", appointmentRepo.save(pp));
			}
            return map;
            }else {
                map.put("msg", "appointment status not found");
         		return map;
            }

 	}
    @Override
	public Object deleteAppointment(int id) {
    	Map<String, Object> map=new HashMap<String, Object>();
		appointmentRepo.deleteById(id);
		map.put("status", 1);
 		return map;
	}

    @Override
	public Object addNewAppointment(Appointment appointment) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Appointment> app=appointmentRepo.findByPatientId(appointment.getPatientId());
		if(app!=null) {
			Appointment pp=app.get(0);
			//for(Appointment pp: ppp) {
            if(appointment.getAppointmentStatus()!=null){
                pp.setAppointmentStatus(appointment.getAppointmentStatus());}
            
            if(appointment.getAptId()!=null) {
            	pp.setAptId(appointment.getAptId());}
            if(appointment.getCreatedAt()!=null) {
            	pp.setCreatedAt(appointment.getCreatedAt());}
            if(appointment.getDate()!=null) {
            	pp.setDate(appointment.getDate());}
            if(appointment.getDepartment()!=null) {
            	pp.setDepartment(appointment.getDepartment());}
            if(appointment.getDoctorId()!=null) {
            	pp.setDoctorId(appointment.getDoctorId());}
            if(appointment.getEmail()!=null) {
            	pp.setEmail(appointment.getEmail());}
            if(appointment.getGender()!=null) {
            	pp.setGender(appointment.getGender());}
          //  if(appointment.getId()!=0) {
           // 	pp.setId(appointment.getId());}
            if(appointment.getMessage()!=null) {
            	pp.setMessage(appointment.getMessage());}
            if(appointment.getMobileNumber()!=null) {
            	pp.setMobileNumber(appointment.getMobileNumber());}
            if(appointment.getPatientId()!=null) {
            	pp.setPatientId(appointment.getPatientId());}
            if(appointment.getPatientName()!=null) {
            	pp.setPatientName(appointment.getPatientName());}
            if(appointment.getSource()!=null) {
            	pp.setSource(appointment.getSource());}
            if(appointment.getUpdatedAt()!=null) {
            	pp.setUpdatedAt(appointment.getUpdatedAt());}
            if(appointment.getUpdatedAt()!=null) {
            	pp.setUpdatedAt(appointment.getUpdatedAt());}
            if(appointment.getCreatedAt()!=null) {
            	pp.setCreatedAt(appointment.getCreatedAt());}
            map.put("saved data", appointmentRepo.save(pp));
            return map;
            }else {
                map.put("msg", "appointment details not found");
         		return map;
            }
        }
    
    @Override
    public List<Appointment> getByDate(String date){
    	//LocalDate dateBefore30Days = LocalDate.now().minusDays(30);
        //List<Appointment> persons =  appointmentRepo.findByDateGreaterThan(dateBefore30Days);
    	 
		return appointmentRepo.findByDate(date);
        }
    @Override
	public Object getOneWeekAppointments(String date) {
		//Pageable topTen = new PageRequest(0, 10, Direction.ASC, "date"); 
		//List<Appointment> result = appointmentRepo.findByDate("date", topTen);
		List<Map<String, Object>> al=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		Page<Appointment> page = appointmentRepo.findAll(
		PageRequest.of(0, 7, Sort.by(Sort.Direction.DESC, "date")));
		if(page.getSize()!=0) {
			for(Appointment a:page) {
				 
				map.put("date", a.getDate());
				map.put("appointmentStatus", a.getAppointmentStatus());
				map.put("aptId", a.getAptId());
				map.put("email", a.getEmail());
				map.put("gender", a.getGender());
				al.add(map);

			}
		}
 		//return appointmentRepo.findAll()
		return al;
	}

	@Override
	public List<Appointment> getAll() {
 		return appointmentRepo.getAll();
	}

	//@Override
	//public List<Appointment> findFirst10ByDate(String date) {
 		//return appointmentRepo.findTop3ByOrderByDateAsc(date);
	//}
    	
    }
	/*
	 * public List<Appointment> getBetweenDates(String date, String date1){
	 * DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); LocalDateTime start =
	 * LocalDateTime.parse(date, formatter); LocalDateTime end =
	 * LocalDateTime.parse(date, formatter); Calendar calendar =
	 * Calendar.getInstance(); int offset = calendar.get(Calendar.DAY_OF_WEEK) - 1;
	 * calendar.add(Calendar.DATE, -offset); for(int i = 0; i < 7; i++){
	 * System.out.println(calendar.getTime()); calendar.add(Calendar.DATE, 1);
	 * 
	 * return null;
	 * 
	 * public static List<LocalDate> datesOfWeekDate(LocalDate date) {
    LocalDate monday = date
            .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

    return IntStream.range(0, 7).mapToObj(monday::plusDays).collect(toList());
}

	 * }
	 */
		 

		 
