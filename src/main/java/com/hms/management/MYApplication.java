package com.hms.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
 

 
  @SpringBootApplication
 @EnableSwagger2
  public class MYApplication extends SpringBootServletInitializer {

	  
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		  return application.sources(MYApplication.class);
	  }
	  
	  
	  
	  
	public static void main(String[] args) {
		SpringApplication.run(MYApplication.class, args);
	/*String str[]= {"revanhj1993@gmail.com"};
		EmailSender.sendMail("revanhj1993@gmail.com", "sunday14031993", "D", str);
	}*/
	}
	
	  @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { return new
	  BCryptPasswordEncoder(); }
	 
	}
 