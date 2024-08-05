package com.spring.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	Payment findByName(String name);

}
