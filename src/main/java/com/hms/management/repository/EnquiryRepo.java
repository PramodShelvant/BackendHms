package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer>{

}
