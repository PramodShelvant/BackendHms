package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.ScheduleList;

public interface ScheduleListRepository extends JpaRepository<ScheduleList, Integer>{

 
	List<ScheduleList> findByDoctorId(String doctorId);

}
