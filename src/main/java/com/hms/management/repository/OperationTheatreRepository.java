package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.model.OperationTheatre;

public interface OperationTheatreRepository extends JpaRepository<OperationTheatre, Integer>{

	public OperationTheatre findByPatientId(String patientId);

     //@Query(value = "SELECT * FROM hospitalManagement.operation_theatre WHERE  operation_date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()",nativeQuery = true)
   // public List<OperationTheatre> findByGetCurrentMontReport();

}
