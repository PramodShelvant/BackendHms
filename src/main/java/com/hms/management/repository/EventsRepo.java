package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Events;

public interface EventsRepo extends JpaRepository<Events, Integer>{

}
