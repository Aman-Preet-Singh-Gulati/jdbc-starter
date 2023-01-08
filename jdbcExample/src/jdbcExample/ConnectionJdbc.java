package jdbcExample;
import java.sql.*;

public class ConnectionJdbc {
	
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
