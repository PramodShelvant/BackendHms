package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.NotificationSetting;

public interface NotificationSettingRepo extends JpaRepository<NotificationSetting, Integer>{

}
