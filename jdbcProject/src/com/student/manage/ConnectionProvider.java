package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con;
	public static Connection createConnection()
	{
		try {			
			// Load the driver
			/*
			 * Note: For MySQL version < 5.0.0 - com.mysql.jdbc.Driver 
			 * For MySQL version > 5.0.0 - com.mysql.cj.jdbc.Driver
			 */
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC driver loaded");
			
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String username = "root";
			String password = "1234";	
			
			// Creating connection with MySQL database using DriverManager class
			con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
		return con;
	}

}
