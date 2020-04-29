package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {

}
