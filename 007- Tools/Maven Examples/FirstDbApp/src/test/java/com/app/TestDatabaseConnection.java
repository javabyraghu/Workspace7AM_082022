package com.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

public class TestDatabaseConnection {
	
	@Test
	public void testGetConnection() {
		DatabaseConnection dbc = new DatabaseConnection();
		Connection con = dbc.getConnection();
		assertNotNull(con);
	}
	
}
