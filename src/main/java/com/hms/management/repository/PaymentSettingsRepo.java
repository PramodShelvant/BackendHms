package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.PaymentSettings;

public interface PaymentSettingsRepo extends JpaRepository<PaymentSettings, Integer>{

}
