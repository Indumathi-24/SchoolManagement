package com.project.SchoolManagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.project.school.client.SchoolManagementStudentApplication;
import com.project.school.dao.SchoolManagementStudentDAOImpl;
import com.project.school.model.Student;
import com.project.school.util.DBUtil;


class SchoolManagementStudentDAOImplTest {
	SchoolManagementStudentApplication studentApp =new SchoolManagementStudentApplication();
	SchoolManagementStudentDAOImpl studentDAOImpl=new SchoolManagementStudentDAOImpl();
	List<Student> studentList =new ArrayList<Student>();
	@Test
	void testAddStudentDetails() {
	long beforeAdd=0;
	long afterAdd=0;
	try{
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	ResultSet rs=null;
	System.out.println("Before Adding");
	rs=st.executeQuery("select * from Student");
	while(rs.next()){
	    beforeAdd++;
	 }
	studentApp.addStudent();
	System.out.println("After Adding");
	rs=st.executeQuery("select* from Student");
	while(rs.next()){
	   afterAdd++;
	  }
	}
	catch(Exception e){
	   e.printStackTrace();
	} 
	assertNotSame(beforeAdd,afterAdd);
	}
	
	@Test
	void testReadAllStudentDetails() {
		
		SchoolManagementStudentDAOImpl DAOImplTest=new SchoolManagementStudentDAOImpl();
		studentList=DAOImplTest.readAllStudentDetails();
		assertNotNull(studentList);
		
	}

	@Test
	void testReadStudentDetailsById() {
		Student student =new Student();
		SchoolManagementStudentDAOImpl DAOImplTest=new SchoolManagementStudentDAOImpl();
		student=DAOImplTest.readStudentDetailsById();
		assertNotNull(student);
	}

	@Test
	void testUpdateStudentDetails() {
		List<Student> beforeStudentUpdateList = new ArrayList<>();
		List<Student> afterStudentUpdateList = new ArrayList<>();
		System.out.println("Enter the roll no update:");
		Scanner sc=new Scanner(System.in);
		int rno=sc.nextInt();
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select* from Student where rollNo=?");
			pst.setInt(1, rno);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				beforeStudentUpdateList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5)));
			}
			System.out.println(beforeStudentUpdateList);
			studentDAOImpl.updateStudentDetails();
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				afterStudentUpdateList.add(new Student(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
			}
			System.out.println(afterStudentUpdateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertFalse(Arrays.equals(beforeStudentUpdateList.toArray(), afterStudentUpdateList.toArray()));
}
	@Test
	void testDeleteStudentDetails() {
	    long beforeDelete=0;
	    long afterDelete=0;
	try{
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	ResultSet rs=null;
	System.out.println("Before deleting");
	rs=st.executeQuery("select* from Student");
	while(rs.next()){
	    beforeDelete++;
	}
	studentDAOImpl.deleteStudentDetails();
	System.out.println("After deleting");
	rs=st.executeQuery("select* from Student");
	while(rs.next()){
	  afterDelete++;
	}
	}
	catch(Exception e){
	e.printStackTrace();
	}
	assertNotSame(beforeDelete,afterDelete);
	}
	
}
