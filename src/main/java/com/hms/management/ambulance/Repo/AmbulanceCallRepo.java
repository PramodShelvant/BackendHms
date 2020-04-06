package com.hms.management.ambulance.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.ambulance.model.Ambulancecall;

public interface AmbulanceCallRepo extends JpaRepository<Ambulancecall, Integer> {
	@Query("select new Map(c.id as id,c.amount as amount,v.driverName as driverName,c.vehicleid as vehicleid,c.patientName as patientName"
			+ ",c.contactNo as contactNo,c.date as date,v.vehicleNo as vehicleNo,v.vehicleModel as vehicleModel,c.address as address) from Ambulancecall c inner join Ambulance v on c.vehicleid=v.id")
	List<?> fetchAll();

}
