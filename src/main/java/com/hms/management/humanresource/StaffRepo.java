package com.hms.management.humanresource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepo extends JpaRepository<Staff, String> {

	
	@Query("select new Map(s.staffId as staffId,"
			+ "d.name as department,d1.name as designation,s.firstName as name,s.role as role,s.phone as phone)"
			+ " from com.hms.management.humanresource.Staff s left join Designation d1 on d1.id=s.designationId "
			+ "left join Department d on d.id=s.departmentId")
	List<?> fetchAll();
	
}
