package com.app.raghu.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.raghu.service.ProducerService;

@Component
public class TestProducer {
	
	@Autowired
	private ProducerService service;

	@Scheduled(cron = "*/10 * * * * *")
	public void sendTestData() {
		service.send("Hello " + new Date());
	}
	
}
