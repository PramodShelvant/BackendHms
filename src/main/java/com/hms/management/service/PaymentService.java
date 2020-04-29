package com.hms.management.service;

import java.util.List;

import com.hms.management.model.Payment;

public interface PaymentService {

	Payment addPayment(Payment payment);

	List<Payment> getPayment(String opdId);

}
