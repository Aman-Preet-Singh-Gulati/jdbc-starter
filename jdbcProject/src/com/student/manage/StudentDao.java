package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public static boolean AddStudent(Student st)
	{
		boolean flag = false;
		// JDBC code
		try {
			// Established connection using ConnectionProvider class
			Connection con = ConnectionProvider.createConnection();
			
			// Creating the query to insert the data in database
			String q = "insert into students(sname, sphone, scity) values(?,?,?)";
			
			// Prepared statement - because we are implementing dynamic query
			PreparedStatement stmt = con.prepareStatement(q);
			
			// Setting the values of parameters
			stmt.setString(1, st.getStudentName());
			stmt.setString(2, st.getStudentPhone());
			stmt.setString(3, st.getStudentName());
			
			//execute
			stmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean DeleteStudent(int ID) {
		
		boolean flag = false;
		// JDBC code
		try {
			// Established connection using ConnectionProvider class
			Connection con = ConnectionProvider.createConnection();
			
			// Creating the query to insert the data in database
			String q = "delete from student where sid=?";
			
			// Prepared statement - because we are implementing dynamic query
			PreparedStatement stmt = con.prepareStatement(q);
			
			// Setting the values of parameters
			stmt.setInt(1, ID);
			
			//execute
			stmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;

	}

	public static void DisplayAllstudents() {
		
		boolean flag = false;
		// JDBC code
		try {
			// Established connection using ConnectionProvider class
			Connection con = ConnectionProvider.createConnection();
			
			// Creating the query to insert the data in database
			String q = "select * from students";
			
			// Prepared statement - because we are implementing dynamic query
			Statement stmt = con.createStatement();
			
			//execute
			ResultSet set = stmt.executeQuery(q);
			
			while (set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID: "+id+" Name: "+name+" Phone number: "+phone+" City: "+city);
				System.out.println("_____________________________________________________________");

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

