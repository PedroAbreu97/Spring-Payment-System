package com.spring.payment.service;

import com.spring.payment.entity.Payment;
import com.spring.payment.repository.PaymentRepository;
import com.spring.payment.request.dto.PaymentCreateRequest;
import com.spring.payment.response.dto.PaymentResponseDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {
	
	private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @Override
    public PaymentResponseDTO createPayment(PaymentCreateRequest paymentRequestDTO) {
        Payment payment = convertToEntity(paymentRequestDTO);
        Payment savedPayment = paymentRepository.save(payment);
        return convertToResponseDTO(savedPayment);
    }

    private Payment convertToEntity(PaymentCreateRequest paymentRequestDTO) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentRequestDTO, payment);
        return payment;
    }

    private PaymentResponseDTO convertToResponseDTO(Payment payment) {
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        BeanUtils.copyProperties(payment, responseDTO);
        return responseDTO;
    }
	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}
	@Override
	public Payment getPaymentById(long id) {
		 Optional<Payment> payment =  paymentRepository.findById(id);
	        if(payment.isPresent()){
	            return payment.get();
	        }else {
	            throw new RuntimeException();
	        }
	
		
	}

}
