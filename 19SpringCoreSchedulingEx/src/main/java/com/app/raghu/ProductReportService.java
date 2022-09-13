package com.app.raghu;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProductReportService {
	
	//@Scheduled(fixedDelay = 2000) //in milli sec
	//@Scheduled(fixedDelayString = "2000") //in milli sec
	//@Scheduled(fixedRate = 2000)
	//@Scheduled(cron = "10 * * * * *")
	@Scheduled(cron = "*/10 * * * * *")
	public void generateReport() {
		System.out.println("HELLO " + new Date());
	}
}
