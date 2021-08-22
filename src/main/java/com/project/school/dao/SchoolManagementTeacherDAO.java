package com.project.school.dao;

import java.util.List;

import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Teacher;


public interface SchoolManagementTeacherDAO {
	public void addTeacherDetails(Teacher teacher);
	public List<Teacher> readAllTeacherDetails();
	public Teacher readTeacherDetailsById();
	public void updateTeacherDetails() throws InvalidRollNoException, InvalidUserChoiceException;
	public void deleteTeacherDetails() throws InvalidRollNoException;
}
