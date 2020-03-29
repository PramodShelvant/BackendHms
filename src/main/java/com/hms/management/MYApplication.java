package com.hms.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



 
 @SpringBootApplication
 @EnableWebMvc
  public class MYApplication extends SpringBootServletInitializer{

//	  
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	 return application.sources(MYApplication.class);
  }
	  
	public static void main(String[] args) {
		SpringApplication.run(MYApplication.class, args);
		
		   
	 
	}
	
	 // @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { 
		//  return new BCryptPasswordEncoder();
	//}
	  
	}
 