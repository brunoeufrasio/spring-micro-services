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
 
@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workId, int days) {
		Map<String, String> json = new HashMap<>();
		json.put("id", ""+workId);
	
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, json);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);		
	}
	

}
