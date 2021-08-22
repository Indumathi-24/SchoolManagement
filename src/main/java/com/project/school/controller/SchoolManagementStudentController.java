package com.project.school.controller;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Student;
import com.project.school.service.SchoolManagementStudentService;
import com.project.school.service.SchoolManagementStudentServiceImpl;



public class SchoolManagementStudentController {
	SchoolManagementStudentService schoolStudentServiceImpl =new SchoolManagementStudentServiceImpl(); 
	static Logger logger=Logger.getLogger("SchoolManagementStudentController.class");
    public void addStudentDetails(Student student) {
    	logger.info("In School Management Student Controller");
    	logger.info("In Add Student Details Method");
			
    	schoolStudentServiceImpl.addStudentDetails(student); 
    }
    public List<Student> readAllStudentDetails() {
    	logger.info("In School Management Student Controller");
    	logger.info("In Read All Student Details Method");
    	List<Student> studentList = new ArrayList<Student>();
    	try {
			 studentList=schoolStudentServiceImpl.readAllStudentDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return studentList;
    	 
     }
    public Student readStudentDetailsById() {
    	logger.info("In School Management Student Controller");
    	logger.info("In Read Student Details Method");
    	Student student = new Student();
	    student=schoolStudentServiceImpl.readStudentDetailsById();
		
    	return student;
    	 
     }
    
		
    public void updateStudentDetails() throws InvalidRollNoException, InvalidUserChoiceException { 
    	logger.info("In School Management Student Controller");
    	logger.info("In Update Student Details Method");
		schoolStudentServiceImpl.updateStudentDetails();
	 } 
    public void deleteStudentDetails() throws InvalidRollNoException { 
    	logger.info("In School Management Student Controller");
    	logger.info("In Delete Student Details Method");
        schoolStudentServiceImpl.deleteStudentDetails(); 
     	 
    } 		 
}
