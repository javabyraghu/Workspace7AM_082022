package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.MyAppConfig;
import com.app.controller.MyController;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);
		MyController mc =  ac.getBean("myController",MyController.class);
		System.out.println(mc);
	}
}
