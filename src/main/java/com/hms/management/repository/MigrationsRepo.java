package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Migrations;

public interface MigrationsRepo extends JpaRepository<Migrations, Integer>{

}
