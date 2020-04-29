package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.BloodIssue;

public interface BloodIssueRepository extends JpaRepository<BloodIssue, Integer>{

	
	
	
    //Starting from 1st Jan of the current month till now.
    @Query(value = "SELECT * FROM hospitalManagement.blood_issue WHERE  reporting_date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
    public List<BloodIssue> findAllCurrentMontReport();

    //Starting from 1st Jan of the current Year till now.
    @Query(value = "SELECT * FROM hospitalManagement.blood_issue WHERE  date_of_issue between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()", nativeQuery = true)
    public List<BloodIssue> findAllCurrentYearReport();
    
    // seven days reports from current date
    @Query(value = "SELECT * FROM hospitalManagement.blood_issue WHERE date_of_issue BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE()",nativeQuery = true)
    public List<BloodIssue> findAllLastsevenDaysReport();

    
    //last three months records
    @Query(value = "select * from hospitalManagement.blood_issue where date_of_issue BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 3 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BloodIssue> findAllLatThreeMonthsReports();

    
    //last six month reports till current date
    @Query(value = "select * from hospitalManagement.blood_issue where date_of_issue BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 6 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BloodIssue> findAllLastSixMonthReports();

    //last nine months reports till now
   @Query(value = "select * from hospitalManagement.blood_issue where date_of_issue BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 9 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	public List<BloodIssue> findAllLastNineMonthReports();

    
    
    //last twelve months reports till now
    @Query(value = "select * from hospitalManagement.blood_issue where date_of_issue BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 12 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BloodIssue> findAllLasttwelveMonthReports();

    
    //last maonth records
    @Query(value = "select * from hospitalManagement.blood_issue where date_of_issue BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 1 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	public List<BloodIssue> findAllLastMonth();

 
}
