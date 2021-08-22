package com.project.school.dao;

import java.util.List;

import com.project.school.exceptions.InvalidRollNoException;
import com.project.school.exceptions.InvalidUserChoiceException;
import com.project.school.model.Student;

public interface SchoolManagementStudentDAO {
	public void addStudentDetails(Student student);
	public List<Student> readAllStudentDetails();
	public Student readStudentDetailsById();
	public void updateStudentDetails() throws InvalidRollNoException, InvalidUserChoiceException;
	public void deleteStudentDetails() throws InvalidRollNoException;
}
