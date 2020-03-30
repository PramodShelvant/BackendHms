package com.hms.management.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.management.EmailSender;
import com.hms.management.beans.StaffBean;
import com.hms.management.exception.RecordNotFoundException;
import com.hms.management.model.Staff;
import com.hms.management.model.UserRegistration;
import com.hms.management.serviceimpl.StaffServiceImpl;
import com.hms.management.serviceimpl.UserRegistrationServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("/staff")
public class StaffCotroller {

	
	
	private static String UPLOADED_FOLDER = "/";

	@Autowired
	public StaffServiceImpl staffServiceImpl;
	@Autowired
	public UserRegistrationServiceImpl userserviceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/",method = RequestMethod.POST)
    public Object addstaff(StaffBean staffBean) throws RecordNotFoundException {
    	System.out.println("from staffbean"+staffBean);
 		Staff n=new Staff();
		System.out.println(n.toString());
         byte[] bytes = null;
		try {
			bytes = staffBean.getPhoto().getBytes();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        Path path = Paths.get(UPLOADED_FOLDER + staffBean.getPhoto().getOriginalFilename());
           try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        n.setPhoto(UPLOADED_FOLDER + staffBean.getPhoto().getOriginalFilename());
        n.setBloodGroup(staffBean.getBloodGroup());
        n.setCurrentAddrees(staffBean.getCurrentAddress());
        n.setDateOfBirth(staffBean.getDateOfBirth());
        n.setDateOfJoining(staffBean.getDateOfJoining());
        n.setDepartment(staffBean.getDepartment());
        n.setDesignation(staffBean.getDesignation());
        n.setEmail(staffBean.getEmail());
        n.setFatherName(staffBean.getFatherName());
        n.setMotherName(staffBean.getMotherName());
        n.setFirstName(staffBean.getFirstName());
        n.setGender(staffBean.getGender());
        n.setLastName(staffBean.getLastName());
        n.setMaritalStatus(staffBean.getMaritalStatus());
        n.setWorkExperiance(staffBean.getWorkExperiance());
        n.setStaffId(staffBean.getStaffId());
        n.setSpecialization(staffBean.getSpecialization());
        n.setRole(staffBean.getRole());
        n.setQualification(staffBean.getQualification());
        n.setPhone(staffBean.getPhone());
        n.setPermnentAddress(staffBean.getPermnentAddress());
        n.setNote(staffBean.getNote());
        n.setAccountNumber(staffBean.getAccountNumber());
        n.setAccountTitle(staffBean.getAccountTitle());
        n.setBankBranchName(staffBean.getBankBranchName());
        n.setBankName(staffBean.getBankName());
        n.setIfscCode(staffBean.getIfscCode());
        n.setStaffId("STAFFID-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
		Staff s=(Staff) staffServiceImpl.addStaff(n);
		if(s!=null) {
UserRegistration u=new UserRegistration();
	u.setEmail(s.getEmail());
	u.setMobileNo(s.getPhone());
	u.setName(s.getFirstName());
	//u.setPassword(appointment.get);
	u.setGender(s.getGender());
	u.setRole(s.getRole());
	u.setUserId(s.getStaffId());
	u.setPassword("12345");
	userserviceImpl.adUserRegistration(u);
	EmailSender.sendMail("revanhj1993@gmail.com", "sunday14031993", "userName:"+s.getEmail()+" password:12345", s.getEmail());
		}
		Map<String,Object> map=new HashMap<>();
		map.put("msg", "success");
		return map;
    }
    
	@CrossOrigin
    @RequestMapping(value =  "/staff/",method = RequestMethod.POST,produces = "application/json")
    public Object addStaff(@RequestBody Staff n) {
		n.setStaffId("STAFFID-"+DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
		Staff s=(Staff) staffServiceImpl.addStaff(n);
		if(s!=null) {
UserRegistration u=new UserRegistration();
	u.setEmail(s.getEmail());
	u.setMobileNo(s.getPhone());
	u.setName(s.getFirstName());
	//u.setPassword(appointment.get);
	u.setGender(s.getGender());
	u.setRole(s.getRole());
	u.setUserId(s.getStaffId());
	u.setPassword("12345");
	userserviceImpl.adUserRegistration(u);
	EmailSender.sendMail("revanhj1993@gmail.com", "sunday14031993", "userName:"+s.getEmail()+" password:12345", s.getEmail());
		}
		Map<String,Object> map=new HashMap<>();
		map.put("msg", "success");
		return map;
    }
 	
	@CrossOrigin
	@GetMapping(value = "/{staffId}",produces = "application/json")
	public Object getByStaffId(@PathVariable String staffId){
		return staffServiceImpl.getByStaffId(staffId);
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
	public List<Staff> getAllStaff(){
		return staffServiceImpl.getAllStaff();
		
	}
}







