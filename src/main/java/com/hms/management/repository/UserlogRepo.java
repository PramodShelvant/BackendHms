package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Userlog;

public interface UserlogRepo extends JpaRepository<Userlog, Integer> {

}
