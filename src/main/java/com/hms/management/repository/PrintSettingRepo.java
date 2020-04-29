package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PrintSetting;

public interface PrintSettingRepo extends JpaRepository<PrintSetting, Integer> {

}
