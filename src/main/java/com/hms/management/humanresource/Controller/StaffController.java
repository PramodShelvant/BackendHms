package com.hms.management.humanresource.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hms.management.humanresource.Repo.StaffRepo;
import com.hms.management.humanresource.modal.Staff;
import com.hms.management.model.UserRegistration;
import com.hms.management.repository.UserRegistrationRepository;
import com.hms.management.serviceimpl.UploadFile;

@RestController
@CrossOrigin
@RequestMapping("/humanResource")
public class StaffController {
	
	@Autowired
	private StaffRepo staffRepo;
	@Autowired
	private UploadFile upload;
	@Autowired
	private UserRegistrationRepository userRepo;
	
	@PostMapping("/add")
	public <T> T add(Staff b,@RequestParam("photoFile") Optional<MultipartFile> file1
			,@RequestParam("resumeFile") Optional<MultipartFile> file2,
			@RequestParam("joiningletterFile") Optional<MultipartFile> file3,
			@RequestParam("otherDocumentFile") Optional<MultipartFile> file4) {
		//System.out.println(!photoFile.isEmpty()?photoFile.get().getContentType():"no file");!!
		
		if(b.getStaffId().isEmpty()|| b.getStaffId().equals("null")) {
			if(userRepo.findByEmail(b.getEmail()).size()>0) {
				Map map=new HashMap<>();
				map.put("err", "emailid arready exist");
				return (T) map;
			}
		b.setStaffId(b.getRole()+"-"+DateTimeFormatter.ofPattern("yyyyMMddHHmmssa").format(LocalDateTime.now()));
		
		}
		b.setPhoto(!file1.isEmpty()?upload.upload(file1.get()):b.getPhoto());
		b.setResume(!file2.isEmpty()?upload.upload(file2.get()):b.getResume());
		b.setJoiningLetter(!file3.isEmpty()?upload.upload(file3.get()):b.getJoiningLetter());
		b.setOtherDocuments(!file4.isEmpty()?upload.upload(file4.get()):b.getOtherDocuments());
		Staff s=staffRepo.save(b);
		UserRegistration u=new UserRegistration();
		u.setEmail(s.getEmail());
		u.setMobileNo(s.getPhone());
		u.setName(s.getFirstName() +" "+s.getLastName());
		u.setPassword(s.getRole()+String.valueOf(new Random().nextInt()).substring(0, 5));
		u.setUserProfile(s.getPhoto());
		u.setGender(s.getGender());
		u.setRole(s.getRole());
		u.setSignupDate(new Date());
		u.setUserId(s.getStaffId());
userRepo.save(u);
		return (T) s;
		
	}
	@GetMapping("/get")
	public <T> T get() {
		return (T) staffRepo.fetchAll();
		
	}
	@GetMapping("/get/{role}/{departmentId}")
	public <T> T get(@PathVariable String role,@PathVariable int departmentId) {
		return (T) staffRepo.fetchbystaffroleanddepartment(role, departmentId);
		
	}
	
	@GetMapping("/get/profile/{staffId}")
	public <T> T getByStaffId(@PathVariable String staffId) {
		List<?> map= staffRepo.fetchByStaffId(staffId);
		return (T) ((map.size()>0)?map.get(0):new Staff());
	}
	
	@GetMapping("/get/{staffId}")
	public <T> T getByStaffIdProfile(@PathVariable String staffId) {
		Optional<Staff> map= staffRepo.findById(staffId);
		return (T) (!map.isEmpty()?map.get():new Staff());
	}
	
	@GetMapping("/delete/{staffId}")
	public <T> T delete(@PathVariable String staffId) {
		staffRepo.deleteById(staffId);
		UserRegistration u=userRepo.findByUserId(staffId);
		userRepo.deleteById(u.getId());
		return (T) String.valueOf(staffId);
	}

}
