package com.demoqa.utilities;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	static private String url = "jdbc:sqlserver://localhost:49690;databaseName=BookStore;encrypt=true;trustServerCertificate=true;";
	static private String username = "sa";	
	static private String password = "Password-1";
	static Connection conn;
	
	public static void connect() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to SQL Server successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Boolean getFirstBookTitle() {
		String response = "";
		ResultSet result = null;
		String query = "SELECT TOP 1 * FROM Books";
		
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeQuery(query);
			if (result.next()) {
	            response += result.getString("Title");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Boolean isValid = response.equals("Harry Potter and the Philosopher's Stone");
		System.out.println(response + "\n");
		return isValid;
	}
}
