package com.hms.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.BillSummery;

public interface BillSummeryReposotory extends JpaRepository<BillSummery, Integer>{

	public List<BillSummery> findByOpdId(String opdId);

}
