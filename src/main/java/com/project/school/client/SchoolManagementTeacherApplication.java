package com.project.school.client;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.school.controller.SchoolManagementTeacherController;
import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Teacher;



public class SchoolManagementTeacherApplication {
	public static void addTeacher() throws InvalidRollNoException {
		System.out.println("Enter the number of Teachers");
		 Scanner sc=new Scanner(System.in);
	     int number=sc.nextInt();sc.nextLine();
	     System.out.println("Adding Teachers Details");
		 for(int i=0;i<number;i++) {
			 Teacher teacher = new Teacher();
			 int rollNo=sc.nextInt();sc.nextLine();
			 if(rollNo<1) {
				 throw new InvalidRollNoException("Roll NO is Invalid");
			 }
			 String name=sc.nextLine();
			 String address=sc.nextLine();
			 String dob=sc.nextLine();
			 String standard=sc.nextLine();
			 String designation=sc.nextLine();
			 teacher.setTeacher_rollNo(rollNo);
			 teacher.setTeacher_name(name);
			 teacher.setTeacher_dob(dob);
			 teacher.setTeacher_address(address);
			 teacher.setTeacher_standard(standard);
			 teacher.setTeacher_designation(designation);
			 schoolTeacherController.addTeacherDetails(teacher);
		 }
		 System.out.println("Case 1: Adding Teachers Details is Completed");
	}
	static SchoolManagementTeacherController schoolTeacherController =new SchoolManagementTeacherController();
	static Logger logger=Logger.getLogger("SchoolManagementTeacherApplication.class");
	public static void main(String args[]) throws InvalidRollNoException,InvalidUserChoiceException {
		logger.info("In School Management Teacher Application");
		System.out.println("======School Management Teacher Application======");
		System.out.println("1.======Insertion======");
		System.out.println("2.======Retrieval======");
		System.out.println("3.======Updation======");
		System.out.println("4.======Deletion======");
		System.out.println("Enter your choice");
		Scanner scanner=new Scanner(System.in);
		int userChoice=scanner.nextInt();
		switch(userChoice)
		{
		case 1:{
			addTeacher();
			break;
		}
			
		case 2:{
			System.out.println("Enter choice of retrieval");
			Teacher teacher=new Teacher();
			List<Teacher>teacherList=new ArrayList<Teacher>();
			Scanner sn=new Scanner(System.in);
			int readChoice=sn.nextInt();
			switch(readChoice) {
			case 1:{
				System.out.println("Reading All Teacher Details");
				teacherList=schoolTeacherController.readAllTeacherDetails();
				for(Teacher s:teacherList) {
				    System.out.println(s);
				}
				System.out.println("Case 2: Reading Teachers Details is Completed");
				break;
			}
			case 2:{
				System.out.println("Reading Teacher Details");
				teacher=schoolTeacherController.readTeacherDetailsById();
				System.out.println(teacher);
				System.out.println("Case 2: Reading Teacher Details is Completed");
				break;
			}	
		}
			break;
		}	
		case 3:{
			System.out.println("Updating Teachers Details");
			schoolTeacherController.updateTeacherDetails();
			System.out.println("Case 3: Updating teachers Details is Completed");
			break;
		}
		case 4:{
			System.out.println("Deleting Teachers Details");
			schoolTeacherController.deleteTeacherDetails();
			System.out.println("Case 4: Deleting Teachers Details is Completed");
			break;
		}
		default:
			throw new InvalidUserChoiceException("User Choice is Invalid");	
		}
		
	}
}
