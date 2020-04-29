package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.ConsultantRegister;

public interface ConsultantRegisterRepository extends JpaRepository<ConsultantRegister, Integer>{

 
	public List<ConsultantRegister> findByIpdId(String ipdId);

}
