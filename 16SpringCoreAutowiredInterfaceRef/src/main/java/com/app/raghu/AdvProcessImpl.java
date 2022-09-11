package com.app.raghu;

import org.springframework.stereotype.Component;

@Component("pob")
public class AdvProcessImpl 
	implements IProcess {

	@Override
	public void getProcesCode() {
		System.out.println("P2");
	}

}
