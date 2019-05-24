package com.myanmar.travel.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/travel_db";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "admin";
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(DB_DRIVER);
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
}
