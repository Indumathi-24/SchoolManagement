package com.project.school.service;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.school.dao.SchoolManagementStudentDAO;
import com.project.school.dao.SchoolManagementStudentDAOImpl;
import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Student;


public class SchoolManagementStudentServiceImpl implements SchoolManagementStudentService{
	SchoolManagementStudentDAO schoolManagementStudentDAO=new SchoolManagementStudentDAOImpl();
	static Logger logger=Logger.getLogger("SchoolManagementStudentServiceImpl.class");
	public void addStudentDetails(Student student) {
		logger.info("In School Management Student Service");
		logger.info("In Add Student Details Method");
		schoolManagementStudentDAO.addStudentDetails(student);
	}
   public List<Student> readAllStudentDetails() {
		logger.info("In Read All Student Details Method");
    	List<Student> studentList = new ArrayList<Student>();
    	
	    studentList=schoolManagementStudentDAO.readAllStudentDetails();

    	return studentList;
    	 
     }
    public Student readStudentDetailsById() {
    	logger.info("In School Management Student Service");
    	logger.info("In Read Student Details Method");
    	Student student = new Student();
    	
		student=schoolManagementStudentDAO.readStudentDetailsById();
	
    	return student;
    	 
     }
	
	public void updateStudentDetails() throws InvalidUserChoiceException,InvalidRollNoException {
		logger.info("In School Management Student Service");
		logger.info("In Update Student Details Method");
		schoolManagementStudentDAO.updateStudentDetails(); 
	      
	}
    public void deleteStudentDetails()throws InvalidRollNoException {
    	logger.info("In School Management Student Service");
    	logger.info("In Delete Student Details Method");
    	schoolManagementStudentDAO.deleteStudentDetails(); 
 	      
    }
}