package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
