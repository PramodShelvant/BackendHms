package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Organisation;

public interface OrganisationRepo extends JpaRepository<Organisation, Integer>{

}
