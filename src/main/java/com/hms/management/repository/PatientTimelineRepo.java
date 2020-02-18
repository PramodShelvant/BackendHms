package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PatientTimeline;

public interface PatientTimelineRepo extends JpaRepository<PatientTimeline, Integer>{

}
