package com.spring.payment.service;


import java.util.List;

import com.spring.payment.entity.Payment;
import com.spring.payment.request.dto.PaymentCreateRequest;
import com.spring.payment.response.dto.PaymentResponseDTO;

public interface PaymentService {
	
	  PaymentResponseDTO createPayment(PaymentCreateRequest paymentRequestDTO);
	  
	    List<Payment> getAllPayments();
	    
	    Payment getPaymentById(long id);
	    
	   

}
