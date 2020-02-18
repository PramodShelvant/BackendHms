package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.AmbulanceCall;

public interface AmbulanceCallRepository extends JpaRepository<AmbulanceCall, Integer>{

}
