package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Vehicles;

public interface VehiclesRepo extends JpaRepository<Vehicles, Integer>{

}
