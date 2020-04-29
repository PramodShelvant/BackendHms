package com.hms.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.FinanceIncome;

 
public interface FinanceIncomeRepository extends JpaRepository<FinanceIncome, Integer>{

	
	//last seven days records
    @Query(value = "SELECT * FROM hospitalManagement.finance_income WHERE date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE()",nativeQuery = true)
    List<FinanceIncome> findAllLastSevenDaysReports();

    
    //current year reports
    @Query(value = "SELECT * FROM hospitalManagement.finance_income WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()", nativeQuery = true)
	List<FinanceIncome> findAllCurrentYearReports();


    
    //current month records
    @Query(value = "SELECT * FROM hospitalManagement.finance_income WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
	List<FinanceIncome> findAllCurrentMonthReports();


    
    //last three months records
    @Query(value = "select * from hospitalManagement.finance_income where `date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 3 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	List<FinanceIncome> findAllLastThreeMonthReports();


    
    //last twelve months records
    @Query(value = "select * from hospitalManagement.finance_income where `date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 6 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	List<FinanceIncome> findAllLastSixMonthReports();


    
    //last twelve months records
    @Query(value = "select * from hospitalManagement.finance_income where `date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 12 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    List<FinanceIncome> findAllLastTwelveMonthReports();

    //get by date 
	List<FinanceIncome> findBydate(Date date);

}
