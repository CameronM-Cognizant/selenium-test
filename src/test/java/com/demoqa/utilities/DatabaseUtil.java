package com.demoqa.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	public static void main(String[] args) {
		String url = "jdbc:sqlserver://localhost:49690;databaseName=BookStore;encrypt=true;trustServerCertificate=true;";
		String username = "sa"; // Replace with your SQL Server username
		String password = "Password-1"; // Replace with your SQL Server password
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("Connected to SQL Server successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
