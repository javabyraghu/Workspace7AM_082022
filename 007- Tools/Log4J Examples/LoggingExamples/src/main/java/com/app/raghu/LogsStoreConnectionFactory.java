package com.app.raghu;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class LogsStoreConnectionFactory {

	private static BasicDataSource dataSource;

	private LogsStoreConnectionFactory() {
	}

	public static Connection getConnection() throws SQLException {
		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setUrl("jdbc:mysql://localhost:3306/boot7am");
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
		}
		return dataSource.getConnection();
	}

}
