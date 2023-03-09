package com.app.raghu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();

		Product p = new Product();
		p.setProdId(100);
		p.setProdCode("PEN");
		p.setProdCost(200.0);

		ses.saveOrUpdate(p);
		tx.commit();
		ses.close();
	}
}

