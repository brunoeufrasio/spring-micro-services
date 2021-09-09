package com.worker.hrpayroll.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.worker.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workId, int days) {
		return new Payment("bruno", 200.0, days);		
	}
	

}
