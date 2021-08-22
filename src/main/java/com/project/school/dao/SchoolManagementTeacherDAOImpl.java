package com.project.school.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Teacher;
import com.project.school.util.DBUtil;



public class SchoolManagementTeacherDAOImpl implements SchoolManagementTeacherDAO{
	static Logger logger=Logger.getLogger("SchoolManagementTeacherDAOImpl.class");
	public void addTeacherDetails(Teacher teacher) {
		   logger.info("In School Management Teacher DAO");
		   logger.info("In Add Teacher Details Method");
	       try (Connection con=DBUtil.getConnection()){
	    	    String insertQuery="insert into Teacher values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(insertQuery);
				pst.setInt(1, teacher.getTeacher_rollNo());
				pst.setString(2,teacher.getTeacher_name() );
				pst.setString(3,teacher.getTeacher_address());
				pst.setString(4, teacher.getTeacher_dob());
				pst.setString(5, teacher.getTeacher_standard());
				pst.setString(6, teacher.getTeacher_designation());
				pst.executeUpdate();
				System.out.println("Teacher Details Inserted");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
   public List<Teacher> readAllTeacherDetails() {
	   logger.info("In School Management Teacher DAO");
		logger.info("In Read All Teacher Details Method");
		List<Teacher> teacherList=new ArrayList<Teacher>();
		try (Connection con=DBUtil.getConnection()){
			Statement st=con.createStatement();
			String selectQuery="select* from Teacher";
			ResultSet resultSet=st.executeQuery(selectQuery);
			while(resultSet.next()) {
				Teacher teacher=new Teacher();
				teacher.setTeacher_rollNo(resultSet.getInt(1));
				teacher.setTeacher_name(resultSet.getString(2));
				teacher.setTeacher_address(resultSet.getString(3));
				teacher.setTeacher_dob(resultSet.getString(4));
				teacher.setTeacher_standard(resultSet.getString(5));
				teacher.setTeacher_designation(resultSet.getString(6));
				teacherList.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Teacher Details Retrieved");
		return teacherList;
		
	  }
			
    public Teacher readTeacherDetailsById() {
    	    logger.info("In School Management Teacher DAO");
			logger.info("In Read Teacher Details Method");
		    System.out.println("Enter the roll No of the Teacher to be retrieved");
		    Scanner sc=new Scanner(System.in);
		    int rno=sc.nextInt();
		    Teacher teacher=new Teacher();
			try (Connection con=DBUtil.getConnection()){
				PreparedStatement st=con.prepareStatement("select* from Teacher where rollNo=?");
				st.setInt(1,rno);
				ResultSet resultSet=st.executeQuery();
				while(resultSet.next()) {
					teacher.setTeacher_rollNo(resultSet.getInt(1));
					teacher.setTeacher_name(resultSet.getString(2));
					teacher.setTeacher_address(resultSet.getString(3));
					teacher.setTeacher_dob(resultSet.getString(4));
					teacher.setTeacher_standard(resultSet.getString(5));
					teacher.setTeacher_designation(resultSet.getString(6));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Teacher Details Retrieved");
			return teacher;
			
		  }
 
   public void updateTeacherDetails() throws InvalidRollNoException,InvalidUserChoiceException{
	        logger.info("In School Management Teacher DAO");
	        logger.info("In Update Teacher Details Method");
	    	try (Connection con=DBUtil.getConnection()){
	    		PreparedStatement pst=null;
	    		Scanner scanner=new Scanner(System.in);
	    		System.out.println("Enter the rollNo of the Teacher to be modified");
	    		int rno=scanner.nextInt();
	    		if(rno<1) {
	    			throw new InvalidRollNoException("Roll No is Invalid");
	    		}
	    		System.out.println("1. Update name");
	    		System.out.println("2. Update address");
	    		System.out.println("3. Update dob");
	    		System.out.println("4. Update standard");
	    		System.out.println("5. Update Designation");
	    		System.out.println("Enter user choice");
	    		int userChoice=scanner.nextInt();
	    		switch(userChoice) {
	    		case 1:{
	    			   System.out.println("Enter the name of the Teacher to be updated");
	    		       scanner.nextLine();
	    			   String updateName=scanner.nextLine();
	    		       pst=con.prepareStatement("update Teacher set name=? where rollNo=?");
	    		       pst.setString(1, updateName);
	    		       pst.setInt(2,rno);
	    		       pst.executeUpdate();
	    		       System.out.println("Rows Updated");
	    		       break;
	    		}
	    		       
	    		case 2:{
	    			   System.out.println("Enter the Address of the Teacher to be updated");
			           scanner.nextLine();
			           String updateAddress=scanner.nextLine();
			           pst=con.prepareStatement("update Teacher set address=? where rollNo=?");
			           pst.setString(1, updateAddress);
			           pst.setInt(2,rno);
			           pst.executeUpdate();
			       	   System.out.println("Rows Updated");
			       	   break;
	    		}
	    		case 3:{
	    			   System.out.println("Enter the dob of the Teacher to be updated");
		           	   scanner.nextLine();
		               String updateDob=scanner.nextLine();
		               pst=con.prepareStatement("update Teacher set dob=? where rollNo=?");
		               pst.setString(1, updateDob);
		               pst.setInt(2,rno);
		               pst.executeUpdate();
		       	       System.out.println("Rows Updated");
		       	       break;
	    		}
		       	      
	    		case 4:{
	    			   System.out.println("Enter the standard of the Teacher to be updated");
		               scanner.nextLine();
		               String updateStandard=scanner.nextLine();
		               pst=con.prepareStatement("update Teacher set standard=? where rollNo=?");
		               pst.setString(1, updateStandard);
		               pst.setInt(2,rno);
		               pst.executeUpdate();
		       	       System.out.println("Rows Updated");
		       	       break;
	    		}
	    		case 5:{
	    			   System.out.println("Enter the Designation of the Teacher to be updated");
	                   scanner.nextLine();
	                   String updateDesignation=scanner.nextLine();
	                   pst=con.prepareStatement("update Teacher set designation=? where rollNo=?");
	                   pst.setString(1, updateDesignation);
	                   pst.setInt(2,rno);
	                   pst.executeUpdate();
	       	           System.out.println("Rows Updated");
	       	           break;
	    		}
		       	       
		       default:throw new InvalidUserChoiceException("User choice is Invaild");
		               
	    		}
	    		
	    	}
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	 }
  public void deleteTeacherDetails() throws InvalidRollNoException {
	   logger.info("In School Management Teacher DAO");
	   logger.info("In Delete Teacher Details Method");
			try(Connection con=DBUtil.getConnection()){
				PreparedStatement pst=null;
				System.out.println("Enter the roll no of the Teacher to be deleted");
				Scanner scanner=new Scanner(System.in);
				int rno=scanner.nextInt();
				if(rno<1) {
					throw new InvalidRollNoException("Roll No is Invalid");
				}
				String deleteQuery="delete from Teacher where rollNo=?";
				pst=con.prepareStatement(deleteQuery);
				pst.setInt(1,rno);
				pst.execute();
				System.out.println("Rows Deleted");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	    
}



