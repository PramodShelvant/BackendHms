package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.StaffTimeline;

public interface StaffTimelineRepo extends JpaRepository<StaffTimeline, Integer> {

}
