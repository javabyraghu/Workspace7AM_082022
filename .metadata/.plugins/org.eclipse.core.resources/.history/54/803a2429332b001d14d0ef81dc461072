package com.app.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

	public ExcelExportService() {
		super();
		System.out.println("FROM CONSTRUCTOR");
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		System.out.println("FROM SETTER METHOD");
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "ExcelExportService [fileName=" + fileName + ", mode=" + mode + "]";
	}
	
	
}
