package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.BirthRecord;

public interface BirthRecordRepository extends JpaRepository<BirthRecord, Integer>{

	
	
    //last seven days records
    @Query(value = "SELECT * FROM hospitalManagement.birth_record WHERE birth_date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE()",nativeQuery = true)
	public List<BirthRecord> findAllLastSevenDaysReport();

    
    //Starting from 1st Jan of the current Year till now.
    @Query(value = "SELECT * FROM hospitalManagement.birth_record WHERE  birth_date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()", nativeQuery = true)
    public List<BirthRecord> findAllCurrentYearReport();


    
    //this month record till now
    @Query(value = "SELECT * FROM hospitalManagement.birth_record WHERE  birth_date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
	public List<BirthRecord> findAllCurrentMonthReport();


    //last three month record till now
    @Query(value = "select * from hospitalManagement.birth_record where birth_date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 3 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	public List<BirthRecord> findAllLastThreeMonthReport();


    
    //last six month record till now
    @Query(value = "select * from hospitalManagement.birth_record where birth_date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 6 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	public List<BirthRecord> findAllLastSixMonthReport();


    
    //last twelve month record till now
    @Query(value = "select * from hospitalManagement.birth_record where birth_date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 12 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BirthRecord> findAllLastTwelveMonthReport();


	 //last 1 month records till now
    @Query(value = "select * from hospitalManagement.birth_record where `birth_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 1 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BirthRecord> findAllOneMonthReport();


	 @Query(value = "SELECT * FROM birth_record WHERE birth_date Like %?1%", nativeQuery = true)
     public List<BirthRecord> findByBirthDateLike(String birthDate);


	public List<BirthRecord> findByBirthDate(String birthDate);


	public List<BirthRecord> findByBirthDateBetween(String birthDate, String birthDate1);

     //this week notvworking properly
     @Query(value = "SELECT * FROM birth_record WHERE birth_date > DATE_SUB(NOW(), INTERVAL 1 WEEK)",nativeQuery = true)
     public List<BirthRecord> findAllByThisWeek();

}
