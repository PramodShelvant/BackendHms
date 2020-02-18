package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.RadiologyReport;

public interface RadiologyReportRepo extends JpaRepository<RadiologyReport, Integer>{

}
