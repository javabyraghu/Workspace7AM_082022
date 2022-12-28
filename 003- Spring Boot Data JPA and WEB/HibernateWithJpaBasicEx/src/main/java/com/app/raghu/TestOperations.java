package com.app.raghu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOperations {
	public static void main(String[] args) {
		EntityTransaction tx = null;
		try {
			// 1. (Loads Driver, Creates DB Connections, Prepare stmt)
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppDB");
			System.out.println(emf.getClass().getName());

			// 2. (TODO Operations--insert, update,....)
			EntityManager em = emf.createEntityManager();
			System.out.println(em.getClass().getName());

			// 3. create Transaction
			tx = em.getTransaction();
			System.out.println(tx.getClass().getName());
			// 4. Start Transaction
			tx.begin();

			// 5. Perform operation
			// save data into DB
			Employee emp = new Employee();
			emp.setEmpId(10);
			emp.setEmpName("ABC");
			emp.setEmpSal(500.0);

			em.persist(emp); // SQL: INSERT INTO ...

			// 6. commit
			tx.commit();

			// 7. close
			emf.close();
		} catch (Exception e) {
			// rollback if any problem
			tx.rollback();
			e.printStackTrace();
		}
	}
}
