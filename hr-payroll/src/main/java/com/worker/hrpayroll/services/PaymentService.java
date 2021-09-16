package com.worker.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.worker.hrpayroll.entities.Payment;
import com.worker.hrpayroll.entities.Worker;
import com.worker.hrpayroll.feignclients.WorkerFeignClient;
 
@Service
public class PaymentService {
	

	
	@Autowired
	private WorkerFeignClient client;
	
	public Payment getPayment(long workId, int days) {		
		
		Worker worker = client.findById(workId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);		
	}
	

}
