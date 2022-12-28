package com.app.raghu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		//ProductReportService ps = ac.getBean("productReportService",ProductReportService.class);
		ProductReportService ps = ac.getBean(ProductReportService.class);
		
	}
}
