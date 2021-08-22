package com.project.school.service;

import java.util.List;

import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Teacher;


public interface SchoolManagementTeacherService {
	public void addTeacherDetails(Teacher teacher);
	public List<Teacher> readAllTeacherDetails();
	public Teacher readTeacherDetailsById();
	public void updateTeacherDetails() throws InvalidRollNoException,InvalidUserChoiceException;
	public void deleteTeacherDetails()throws InvalidRollNoException; 
}
