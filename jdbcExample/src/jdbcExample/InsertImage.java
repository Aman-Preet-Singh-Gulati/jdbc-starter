//Database for inserting image- CREATE TABLE images (id int primary key auto_increment, pic blob);
package jdbcExample;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage {

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
			String q = "insert into images(pic) values(?)";
			
			// Get PreparedStatement object
			PreparedStatement pstmt = con.prepareStatement(q);
			
			// User input - image file			
			FileInputStream fis = new FileInputStream("C:\\Users\\Pc\\Desktop\\My_pic_0103874.jpeg");
			
			// Set the values to query - file_input_stream
			pstmt.setBinaryStream(1, fis, fis.available());		
			
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
