package com.hms.management.humanresource.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.humanresource.modal.Staff;

public interface StaffRepo extends JpaRepository<Staff, String> {

	
	@Query("select new Map(s.staffId as staffId,"
			+ "d.name as department,d1.name as designation,s.firstName as name,s.role as role,s.phone as phone)"
			+ " from com.hms.management.humanresource.modal.Staff s left join Designation d1 on d1.id=s.designationId "
			+ "left join Department d on d.id=s.departmentId")
	List<?> fetchAll();
	@Query("select new Map(s.staffId as doctorId,s.firstName as firstName,s.lastName as lastName)"
			+ " from com.hms.management.humanresource.modal.Staff s "
			+ "where s.role=?1 and s.departmentId=?2")
	List<?> fetchbystaffroleanddepartment(String role,int id);
	
}
