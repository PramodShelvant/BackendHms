package com.hms.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.FinanceExpenses;

public interface FinanceExpensesRepository extends JpaRepository<FinanceExpenses, Integer>{

	List<FinanceExpenses> findByDate(Date date);

	
	//last seven days records
    @Query(value = "SELECT * FROM hospitalManagement.expenses WHERE date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE()",nativeQuery = true)
	List<FinanceExpenses> findAllLastSevenDaysRec();


    //current month records
    @Query(value = "SELECT * FROM hospitalManagement.expenses WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
	List<FinanceExpenses> findAllCurrentMonthRecordsDaysRec();

    //current year records
    @Query(value = "SELECT * FROM hospitalManagement.expenses WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()", nativeQuery = true)
    List<FinanceExpenses> findAllCurrentYearRecordsDaysRec();


    
    //last three months records
    @Query(value = "select * from hospitalManagement.expenses where `date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 3 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    List<FinanceExpenses> findAllLastThreeRecordsDaysRec();


    //last six months records
    @Query(value = "select * from hospitalManagement.expenses where `date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 6 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	List<FinanceExpenses> findAllLastSixMonthRecordsDaysRec();

    //last twelve months records
    @Query(value = "select * from hospitalManagement.expenses where `date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 12 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
	List<FinanceExpenses> findAllLastTwelveMonthRecordsDaysRec();

}
