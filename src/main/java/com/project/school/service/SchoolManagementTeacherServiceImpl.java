package com.project.school.service;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.school.dao.SchoolManagementTeacherDAO;
import com.project.school.dao.SchoolManagementTeacherDAOImpl;
import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Teacher;


public class SchoolManagementTeacherServiceImpl implements SchoolManagementTeacherService {
	SchoolManagementTeacherDAO schoolManagementTeacherDAO = new SchoolManagementTeacherDAOImpl();
	static Logger logger=Logger.getLogger("SchoolManagementTeacherServiceImpl.class");
	public void addTeacherDetails(Teacher teacher) {
		logger.info("In School Management Teacher Service");
		logger.info("In Add Student Details Method");
		schoolManagementTeacherDAO.addTeacherDetails(teacher);
	}

	public List<Teacher> readAllTeacherDetails() {
		logger.info("In School Management Teacher Service");
		logger.info("In Read All Teacher Details Method");
    	List<Teacher> teacherList = new ArrayList<Teacher>();
    	
	    teacherList=schoolManagementTeacherDAO.readAllTeacherDetails();

    	return teacherList;
    	 
     }
    public Teacher readTeacherDetailsById() {
    	logger.info("In School Management Teacher Service");
    	logger.info("In Read Teacher Details Method");
    	Teacher teacher = new Teacher();
    	
		teacher=schoolManagementTeacherDAO.readTeacherDetailsById();
	
    	return teacher;
    	 
     }
	public void updateTeacherDetails() throws InvalidUserChoiceException, InvalidRollNoException {
		logger.info("In School Management Teacher Service");
		logger.info("In Update Teacher Details Method");
		schoolManagementTeacherDAO.updateTeacherDetails();
		
	}
	public void deleteTeacherDetails() throws InvalidRollNoException {
		logger.info("In School Management Teacher Service");
		logger.info("In Delete Teacher Details Method");
		schoolManagementTeacherDAO.deleteTeacherDetails();
		
	}
}
