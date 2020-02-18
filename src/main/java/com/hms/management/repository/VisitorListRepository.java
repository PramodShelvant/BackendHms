package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.management.model.VisitorList;
@Repository
public interface VisitorListRepository extends JpaRepository<VisitorList, Integer>{

}
