package com.hms.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



 
 @SpringBootApplication
  public class MYApplication{

//	  
//	  @Override
//	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		  return application.sources(MYApplication.class);
//	  }
	  
	public static void main(String[] args) {
		SpringApplication.run(MYApplication.class, args);
		
		   
	 
	}
	
	 // @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { 
		//  return new BCryptPasswordEncoder();
	//}
	  
	}
 