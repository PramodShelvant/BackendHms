package com.hms.management.humanresource.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hms.management.humanresource.Repo.StaffLeaveRepo;
import com.hms.management.humanresource.modal.StaffLeave;
import com.hms.management.serviceimpl.UploadFile;

@RestController
@CrossOrigin
@RequestMapping("/humanResource/leave")
public class StaffLeaveController {
	
	@Autowired
	private StaffLeaveRepo staffLeaveRepo;
	@Autowired
	private UploadFile upload;
	
	@PostMapping("/add")
	public <T> T add(StaffLeave s,@RequestParam("file") Optional<MultipartFile> file) {
		if(!file.isEmpty())
			s.setAttachDocument(upload.upload(file.get()));
		//if(!s.getStatus().isEmpty())
			
		return (T)staffLeaveRepo.save(s);
	}
	
	@GetMapping("/get")
	public <T> T get() {
		return (T)staffLeaveRepo.fetchAll();
	}
	@GetMapping("/get/{staffId}")
	public <T> T get(@PathVariable String staffId) {
		return (T)staffLeaveRepo.fetchBystaffId(staffId);
	}
	@GetMapping("/delete/{id}")
	public <T> T delete(@PathVariable int id) {
		staffLeaveRepo.deleteById(id);
		return (T)(""+id);
	}

}
