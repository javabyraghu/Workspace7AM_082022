package com.app.raghu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);
		Object ob = ac.getBean("myService");
		System.out.println(ob);
	}
}
