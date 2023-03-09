package com.app.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/bootdb";
	private static String username = "root";
	private static String password = "root";
	private static String sql = "insert into student values(?,?,?)";

	public static void main(String[] args) throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 10);
		pstmt.setString(2, "AJ");
		pstmt.setDouble(3, 3.3);
		int count = pstmt.executeUpdate();
		System.out.println("Inserted:" + count);
		con.close();
	}
}
