package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boot7am",
					"root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
