package com.hms.management.beans;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationBean {

	
	private int id;
	private String name;
	private String mobileNo;
 	private String email;
	private String password;
	private String userId;
	private Date signupDate;
	private String role;
	private MultipartFile userProfile;
	

}
