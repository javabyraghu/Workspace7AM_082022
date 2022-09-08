package com.app.raghu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/myconfig/beans.xml");
		//Reading object from container
		Token tob1 = ac.getBean("t1",Token.class);
		System.out.println(tob1.hashCode());
		
		//Reading object from container
		Token tob2 = ac.getBean("t1",Token.class);
		System.out.println(tob2.hashCode());
	}
}
