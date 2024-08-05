package com.spring.payment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.payment.entity.Payment;
import com.spring.payment.request.dto.PaymentCreateRequest;
import com.spring.payment.response.dto.PaymentResponseDTO;
import com.spring.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	private final PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentCreateRequest paymentRequestDTO) {
		PaymentResponseDTO createdPayment = paymentService.createPayment(paymentRequestDTO);
		return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
	}
    
	 @GetMapping
	    public List<Payment> getAllPayments(){
	        return paymentService.getAllPayments();
	    }
    
}
