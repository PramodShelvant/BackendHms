package com.hms.management.humanresource.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hms.management.humanresource.modal.StaffLeave;

public interface StaffLeaveRepo extends JpaRepository<StaffLeave, Integer> {

	@Query("select new Map(s.staffId as staffId,d.staffId as ss,s.applyDate as applyDate,s.attachDocument as attachDocument,s.role as role"
			+ ",s.fromDate as fromDate,s.toDate as toDate,s.status as status,s.id as id,s.reason as reason,d.firstName as name,s.note as note"
			+ ",s.leaveTypeId as leaveTypeId,l.name as leaveType) from StaffLeave s inner join com.hms.management.humanresource.modal.Staff d"
			+ " with s.staffId=d.staffId inner join LeaveType l on s.leaveTypeId=l.id")
	List<?> fetchAll();
	
	@Query("select new Map(s.staffId as staffId,s.applyDate as applyDate,s.attachDocument as attachDocument,s.role as role"
			+ ",s.fromDate as fromDate,s.toDate as toDate,s.status as status,s.id as id,s.reason as reason,d.firstName as name,s.note as note"
			+ ",s.leaveTypeId as leaveTypeId,l.name as leaveType) from StaffLeave s inner join com.hms.management.humanresource.modal.Staff d "
			+ "on d.staffId=s.staffId inner join LeaveType l on  s.leaveTypeId=l.id where s.staffId=?1")
	List<?> fetchBystaffId(String staffId);
	
	
}
