package jdbcExample;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class SelectData {

	public static void main(String[] args) {

		try {			
			// Load the driver
			/*
			 * Note: For MySQL version < 5.0.0 - com.mysql.jdbc.Driver 
			 * For MySQL version >5.0.0 - com.mysql.cj.jdbc.Driver
			 */
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC driver loaded");
			
			String url = "jdbc:mysql://localhost:3306/stm";
			String username = "root";
			String password = "1234";	
			
			// Creating connection with MySQL database using DriverManager class
			Connection con = DriverManager.getConnection(url,username,password);
			
			// Create a query
			String q = "select * from new_table";
			
			// Get Statement object - for executing the select query
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				int ID = set.getInt(1);
				String name = set.getString(2);
				String city = set.getString(3);
				System.out.println("ID: "+ID + " Name: " +name+" City: "+city);

			}
			
			System.out.println("Data is fetched from database");
			
			con.close();

			
			if(con.isClosed())
				{
					System.out.println("Connection is closed");
				}
			else
			{
				System.out.println("Connection established");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
