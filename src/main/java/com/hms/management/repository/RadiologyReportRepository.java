package com.hms.management.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.PathologyReport;
import com.hms.management.model.RadiologyReport;

public interface RadiologyReportRepository extends JpaRepository<RadiologyReport, Integer>{

	public List<PathologyReport> findByPatientId(String patientId);

	public Optional<RadiologyReport> findByBillNo(int billNo);

  
	public List<RadiologyReport> findByReportingDate(Date reportingDate);
	
    //last seven days records
     @Query(value = "SELECT * FROM hospitalManagement.radiology_report WHERE reporting_date BETWEEN DATE_SUB( CURDATE() ,INTERVAL 7 DAY ) AND CURDATE()",nativeQuery = true)
     public List<RadiologyReport> findByAllReportingDateLatSevenDays();

     @Query(value = "SELECT * FROM hospitalManagement.radiology_report WHERE  reporting_date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
	 public List<RadiologyReport> findByAllGetCurrentMontReport();

     @Query(value = "SELECT * FROM hospitalManagement.radiology_report WHERE  reporting_date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()", nativeQuery = true)	
     public List<RadiologyReport> findByAllGetCurrentYearReport();

    //last three month record till now //not workibg it properly check it once
     @Query(value = "select * from hospitalManagement.radiology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 3 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	public List<RadiologyReport> findByLastThreeMonthsReport();
   
    //last three month record till now //not workibg it properly check it once
     @Query(value = "select * from hospitalManagement.radiology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 6 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
     public List<RadiologyReport> findByLastSixMonthsReport();

   //last three month record till now //not workibg it properly check it once
     @Query(value = "select * from hospitalManagement.radiology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 9 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
     public List<RadiologyReport> findByLastNineMonthsReport();

     //last twelve month record till now //not workibg it properly check it once
     @Query(value = "select * from hospitalManagement.radiology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 12 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
     public List<RadiologyReport> findByLastTwelveMonthsReport();

	 @Query(value = "SELECT * FROM radiology_report WHERE reporting_date Like %?1%", nativeQuery = true)
	 public List<RadiologyReport> findAnyYearRecord(Date reportingDate);

     
     
     
}
