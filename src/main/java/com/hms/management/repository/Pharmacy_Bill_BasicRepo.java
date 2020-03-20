package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.Pharmacy_Bill_Basic;

public interface Pharmacy_Bill_BasicRepo extends JpaRepository<Pharmacy_Bill_Basic,Integer> {
	@Query("select b as bill,d.name as doctorName,d.userId as doctorId ,"
			+ "u.name as patientName,u.userId as patientId "
			+ "from Pharmacy_Bill_Basic b inner join UserRegistration d on d.userId=b.doctor "
			+ "inner join UserRegistration u on u.userId=b.patientId")
	List<?> fetchBill();
	@Query("select SUBSTRING(p.date,1,10) from Pharmacy_Bill_Basic p where "
			+ "SUBSTRING(p.date,1,10)=CURRENT_DATE")
	List<?> fetchBill(String  date);

}
