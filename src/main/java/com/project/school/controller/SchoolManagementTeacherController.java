package com.project.school.controller;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Teacher;
import com.project.school.service.SchoolManagementTeacherService;
import com.project.school.service.SchoolManagementTeacherServiceImpl;



public class SchoolManagementTeacherController {
	SchoolManagementTeacherService schoolTeacherServiceImpl =new SchoolManagementTeacherServiceImpl(); 
	static Logger logger=Logger.getLogger("SchoolManagementTeacherController.class");
    public void addTeacherDetails(Teacher teacher) {
    	logger.info("In School Management Teacher Controller");
    	logger.info("In Add Teacher Details Method");
        schoolTeacherServiceImpl.addTeacherDetails(teacher);
    }
    public List<Teacher> readAllTeacherDetails() {
    	logger.info("In School Management Teacher Controller");
    	logger.info("In Read All Teacher Details Method");
    	List<Teacher> teacherList = new ArrayList<Teacher>();
	    teacherList=schoolTeacherServiceImpl.readAllTeacherDetails();
		
    	return teacherList;
    	 
    }
   public Teacher readTeacherDetailsById() {
    	logger.info("In School Management Teacher Controller");
    	logger.info("In Read Teacher Details Method");
    	Teacher teacher = new Teacher();
		teacher=schoolTeacherServiceImpl.readTeacherDetailsById();
		
    	return teacher;
    	 
     }
		
    public void updateTeacherDetails() throws InvalidRollNoException, InvalidUserChoiceException { 
    	logger.info("In School Management Teacher Controller");
    	logger.info("In Update Teacher Details Method");
        schoolTeacherServiceImpl.updateTeacherDetails();
	 } 
    public void deleteTeacherDetails() throws InvalidRollNoException { 
    	logger.info("In School Management Teacher Controller");
    	logger.info("In Delete Teacher Details Method");
    	schoolTeacherServiceImpl.deleteTeacherDetails(); 
    }		 
}
