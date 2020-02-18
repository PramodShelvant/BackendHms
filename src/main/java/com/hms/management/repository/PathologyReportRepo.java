package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PathologyReport;

public interface PathologyReportRepo extends JpaRepository<PathologyReport, Integer> {

}
