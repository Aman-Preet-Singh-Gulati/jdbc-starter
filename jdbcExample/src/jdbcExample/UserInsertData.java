package jdbcExample;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserInsertData {

	public static void main(String[] args) {
		
		try {			
			// Load the driver
			/*
			 * Note: For MySQL version < 5.0.0 - com.mysql.jdbc.Driver 
			 * For MySQL version > 5.0.0 - com.mysql.cj.jdbc.Driver
			 */
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC driver loaded");
			
			String url = "jdbc:mysql://localhost:3306/stm";
			String username = "root";
			String password = "1234";	
			
			
			// Creating connection with MySQL database using DriverManager class
			Connection con = DriverManager.getConnection(url,username,password);
			
			// Create a query
			String q = "insert into new_table(tName, tCity) values(?,?)";
			
			// Get PreparedStatement object - for executing the dynamic query
			PreparedStatement pstmt = con.prepareStatement(q);
			
			// User input
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your Name:");
			String name = sc.nextLine();
			
			System.out.println("Enter your City:");
			String city = sc.nextLine();
			
			// Set the values to query
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			
			pstmt.executeUpdate();
			
			System.out.println("Data is inserted in database");
			
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
