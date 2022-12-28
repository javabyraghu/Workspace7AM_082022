package com.app.raghu.gen;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyCustomGen implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) 
			throws HibernateException {
		
		String pref="MYPRD-";
		int random = new Random().nextInt();
		random = Math.abs(random);
		
		String dte = new SimpleDateFormat("ddMMMyy").format(new Date());
		
		return pref+dte+":"+random;
	}
}
