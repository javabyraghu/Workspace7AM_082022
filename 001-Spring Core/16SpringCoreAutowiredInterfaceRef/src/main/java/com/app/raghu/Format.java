package com.app.raghu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Format {
	
	@Autowired
	@Qualifier("pobA")
	private IProcess pob;
	
	public void printFormat() {
		pob.getProcesCode();
		System.out.println("FROM FORMAT");
	}
}
