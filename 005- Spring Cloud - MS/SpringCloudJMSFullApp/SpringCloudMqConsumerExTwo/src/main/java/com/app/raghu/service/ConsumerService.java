package com.app.raghu.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

	@JmsListener(destination = "${my.app.desti-name}")
	public void readData(String message) {
		System.out.println("Consumer#2 : "+message);
	}
}
