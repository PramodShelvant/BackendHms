package com.hms.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.BloodDonor;

public interface BloodDonorRepository extends JpaRepository<BloodDonor, Integer>{

	public List<BloodDonor> findByBloodGroup(String bloodGroup);

	public BloodDonor findByDonorName(String donorName);

	public BloodDonor findByIdAndDonorName(int id, String donorName);

	public BloodDonor findByBloodDonorId(String bloodDonorId);

	
	//last seven days records
    @Query(value = "SELECT * FROM hospitalManagement.blood_donor WHERE donate_date BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 7 DAY ) AND CURDATE()",nativeQuery = true)
    public List<BloodDonor> findAlllastsevenDaysReport();

    
    //current month records
    @Query(value = "SELECT * FROM hospitalManagement.blood_donor WHERE  donate_date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
    public List<BloodDonor> findAllCurrentMonthReports();

    
    //current year records
    @Query(value = "SELECT * FROM hospitalManagement.blood_donor WHERE  donate_date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()", nativeQuery = true)
    public List<BloodDonor> findAllCurrentYearReports();

    
    //last three months recodts
    @Query(value = "select * from hospitalManagement.blood_donor where `donate_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 3 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BloodDonor> findAllCurrentThreeMonthsReports();

    
    //last six months recodts
    @Query(value = "select * from hospitalManagement.blood_donor where `donate_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 6 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BloodDonor> findAllCurrentSixMonthsReports();

    
    //last twelve months recodts
    @Query(value = "select * from hospitalManagement.blood_donor where `donate_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 12 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BloodDonor> findAllCurrentTwelveReports();

    
     //last one months records till now
    @Query(value = "select * from hospitalManagement.blood_donor where `donate_date` BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 1 MONTH ) AND DATE_SUB( CURDATE( ) ,INTERVAL 0 MONTH )",nativeQuery = true)
    public List<BloodDonor> findAllOmeMonthRecords();

    
    //current days reports
	public List<BloodDonor> findByDonateDate(Date donateDate);

}
