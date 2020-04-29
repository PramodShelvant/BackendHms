package com.hms.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hms.management.model.PathologyReport;
 
public interface PathologyReportRepository extends JpaRepository<PathologyReport, Integer> {

	public PathologyReport findByPatientId(String patientId);	

 
	 @Query(value = "SELECT * FROM pathology_report WHERE reporting_date Like %?1%", nativeQuery = true)
     public List<PathologyReport> findByReportingDateLike(Date string);
	
     //Starting from 1st Jan of the current Year till now.
      @Query(value = "SELECT * FROM hospitalManagement.pathology_report WHERE  reporting_date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()", nativeQuery = true)
      public List<PathologyReport> findByAllReportingDate(Date reportingDate);

     //this month record till now
      @Query(value = "SELECT * FROM hospitalManagement.pathology_report WHERE  reporting_date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
	  public List<PathologyReport> findByAllReportingDateMonthRec(Date reportingDate);
      
      //last seven days records
      @Query(value = "SELECT * FROM hospitalManagement.pathology_report WHERE reporting_date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE()",nativeQuery = true)
	  public List<PathologyReport> findByReportingDateLastSevenDaysRec(Date reportingDate);

 
      //last three month record till now 
      @Query(value = "select * from hospitalManagement.pathology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 3 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
      public List<PathologyReport> findByAllReportingDateThreeMonthRec();

      
      //last six month record till now //not workibg it properly check it once
      @Query(value = "select * from hospitalManagement.pathology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 6 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
      public List<PathologyReport> findByAllReportingDateSixMonthRec(@Param("reportingDate") Date reportingDate);

     //last 9 months records till now
      @Query(value = "select * from hospitalManagement.pathology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 9 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
      public List<PathologyReport> findByAllReportingDateNineMonthRec();


     //last 12 months records till now
      @Query(value = "select * from hospitalManagement.pathology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 12 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
      public List<PathologyReport> findByAllReportingDateNineTwelveMonthsRec();


	 //last 1 month records till now
      @Query(value = "select * from hospitalManagement.pathology_report where `reporting_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 1 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
      public List<PathologyReport> findByAllReportingDateLastOneMonthsRec();

 
 
}
