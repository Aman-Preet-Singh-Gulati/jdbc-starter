package jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			String q = "CREATE TABLE new_table(tID int(20) primary key auto_increment, tName varchar(200) not null,"
					+ "tCity varchar(400))";
			
			// Create a statement
			Statement stmt = con.createStatement();
			// executeUpdate because we are adding/updating the database
			stmt.executeUpdate(q);
			System.out.println("Table is created in database");
			
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
