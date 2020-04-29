package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.AmbulanceCall;

public interface AmbulanceCallRepository extends JpaRepository<AmbulanceCall, Integer>{

	public AmbulanceCall findByPatienName(String patienName);

	
	//last seven days records
    @Query(value = "SELECT * FROM hospitalManagement.ambulance_call WHERE date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE()",nativeQuery = true)
    public List<AmbulanceCall> findAllLastsevenDaysRecords();

    //Starting from 1st Jan of the current Year till now.
    @Query(value = "SELECT * FROM hospitalManagement.ambulance_call WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
    public List<AmbulanceCall> findAllCurrentMonthRecords();


    //Starting from 1st Jan of the current Year till now.
    @Query(value = "SELECT * FROM hospitalManagement.ambulance_call WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()", nativeQuery = true)
    public List<AmbulanceCall> findAllCurrentYearReports();


    //last three month record till now //not workibg it properly check it once
    @Query(value = "select * from hospitalManagement.ambulance_call where date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 3 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<AmbulanceCall> findAllThreeMonthsRecords();

    //last six month record till now //not workibg it properly check it once
    @Query(value = "select * from hospitalManagement.ambulance_call where date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 6 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<AmbulanceCall> findAllSixMonthsRecords();


    //last twelve month record till now //not workibg it properly check it once
    @Query(value = "select * from hospitalManagement.ambulance_call where date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 12 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<AmbulanceCall> findAllTwelveMonthsRecords();

 
}
