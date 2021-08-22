package com.project.school.dao;

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

import com.project.school.client.SchoolManagementTeacherApplication;
import com.project.school.model.Teacher;
import com.project.school.model.Teacher;
import com.project.school.model.Teacher;
import com.project.school.util.DBUtil;

class SchoolManagementTeacherDAOImplTest {
	SchoolManagementTeacherApplication teacherApp =new SchoolManagementTeacherApplication();
	SchoolManagementTeacherDAOImpl teacherDAOImpl=new SchoolManagementTeacherDAOImpl();
	@Test
	void testAddTeacherDetails() {
		long beforeAdd=0;
		long afterAdd=0;
		try{
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=null;
		System.out.println("Before Adding");
		rs=st.executeQuery("select * from Teacher");
		while(rs.next()){
		    beforeAdd++;
		 }
		teacherApp.addTeacher();
		System.out.println("After Adding");
		rs=st.executeQuery("select* from Teacher");
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
	void testReadAllTeacherDetails() {
		List<Teacher> teacherList =new ArrayList<Teacher>();
		SchoolManagementTeacherDAOImpl DAOImplTest=new SchoolManagementTeacherDAOImpl();
		teacherList=DAOImplTest.readAllTeacherDetails();
		assertNotNull(teacherList);
	}

	@Test
	void testReadTeacherDetailsById() {
		Teacher teacher=new Teacher();
		SchoolManagementTeacherDAOImpl DAOImplTest=new SchoolManagementTeacherDAOImpl();
		teacher=DAOImplTest.readTeacherDetailsById();
		assertNotNull(teacher);
	}

	@Test
	void testUpdateTeacherDetails() {
		List<Teacher> beforeTeacherUpdateList = new ArrayList<>();
		List<Teacher> afterTeacherUpdateList = new ArrayList<>();
		System.out.println("Enter the roll no update:");
		Scanner sc=new Scanner(System.in);
		int rno=sc.nextInt();
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select* from Teacher where rollNo=?");
			pst.setInt(1, rno);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				beforeTeacherUpdateList.add(new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6)));
			}
			System.out.println(beforeTeacherUpdateList);
			teacherDAOImpl.updateTeacherDetails();
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				afterTeacherUpdateList.add(new Teacher(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6)));
			}
			System.out.println(afterTeacherUpdateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertFalse(Arrays.equals(beforeTeacherUpdateList.toArray(), afterTeacherUpdateList.toArray()));
	}

	@Test
	void testDeleteTeacherDetails() {
		long beforeDelete=0;
	    long afterDelete=0;
	try{
	    Connection con=DBUtil.getConnection();
	    Statement st=con.createStatement();
	    ResultSet rs=null;
	    System.out.println("Before deleting");
	    rs=st.executeQuery("select* from Teacher");
	    while(rs.next()){
	       beforeDelete++;
	    }
	    teacherDAOImpl.deleteTeacherDetails();
	    System.out.println("After deleting");
	    rs=st.executeQuery("select* from Teacher");
	    while(rs.next()){
	      afterDelete++;
	    }
	  }
	   catch(Exception e){
	      e.printStackTrace();
	  }
	}

}
