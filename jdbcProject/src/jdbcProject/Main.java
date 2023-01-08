package jdbcProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management System");
		
		while(true)
		{
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DISPLAY student");
			System.out.println("PRESS 3 to DELETE student");
			System.out.println("PRESS 4 to EXIT application");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int choice = Integer.parseInt(br.readLine());			
			if (choice == 1)
			{
				// ADD student
				System.out.println("Enter student's name: ");
				String name = br.readLine();
				
				System.out.println("Enter student's phone number: ");
				String phone = br.readLine();
				
				System.out.println("Enter student's city: ");
				String city = br.readLine();
				
				Student obj = new Student(name, phone, city);
				boolean answer = StudentDao.AddStudent(obj);
				
				if (answer == true)
				{
					System.out.println("Student Successfully added in database");
				}
				else
				{
					System.out.println("Fail to add student's record in database");
				}
			}
			else if (choice == 2)
			{
				// DISPLAY student
				StudentDao.DisplayAllstudents();
			}
			else if (choice == 3)
			{
				// DELETE student
				System.out.println("Enter student ID to delete");
				int ID = Integer.parseInt(br.readLine());
				boolean answer = StudentDao.DeleteStudent(ID);
				
				if (answer == true)
				{
					System.out.println("Record Successfully deleted from database");
				}
				else
				{
					System.out.println("Fail to delete student's record from database");
				}
				
			}
			else if (choice == 4)
			{
				// EXIT application
				break;
			}
			else
			{
				System.out.println("You have entered wrong option. Please try again");
			}
		}
		System.out.println("Thanks for using this application.");
		System.out.println("See you later!");

	}

}
