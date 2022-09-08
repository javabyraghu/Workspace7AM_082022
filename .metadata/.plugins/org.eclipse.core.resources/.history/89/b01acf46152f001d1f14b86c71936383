package com.app.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("eobj")
public class ExcelExportService {

	private String fileName;
	private String mode;
	
	@PostConstruct
	public void setup() throws Exception {
		//lot of code...
		System.out.println("FROM INIT METHOD");
	}
	
	@PreDestroy
	public void clean() throws Exception {
		//some code..
		System.out.println("FROM DESTORY METHOD");
	}

	
	@Override
	public String toString() {
		return "ExcelExportService [fileName=" + fileName + ", mode=" + mode + "]";
	}
	
	
}
