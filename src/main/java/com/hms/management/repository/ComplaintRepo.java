package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Integer>{

}
