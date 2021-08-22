package com.project.school.model;

public class Teacher {
	private Integer teacher_rollNo;
	private String teacher_name;
	private String teacher_address;
	private String teacher_dob;
	private String teacher_standard;
	private String teacher_designation;
	
	public Teacher() {
		
	}

	public Teacher(Integer teacher_rollNo, String teacher_name, String teacher_address, String teacher_dob,
			String teacher_standard, String teacher_designation) {
		super();
		this.teacher_rollNo = teacher_rollNo;
		this.teacher_name = teacher_name;
		this.teacher_address = teacher_address;
		this.teacher_dob = teacher_dob;
		this.teacher_standard = teacher_standard;
		this.teacher_designation = teacher_designation;
	}

	public Integer getTeacher_rollNo() {
		return teacher_rollNo;
	}

	public void setTeacher_rollNo(Integer teacher_rollNo) {
		this.teacher_rollNo = teacher_rollNo;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_address() {
		return teacher_address;
	}

	public void setTeacher_address(String teacher_address) {
		this.teacher_address = teacher_address;
	}

	public String getTeacher_dob() {
		return teacher_dob;
	}

	public void setTeacher_dob(String teacher_dob) {
		this.teacher_dob = teacher_dob;
	}

	public String getTeacher_standard() {
		return teacher_standard;
	}

	public void setTeacher_standard(String teacher_standard) {
		this.teacher_standard = teacher_standard;
	}

	public String getTeacher_designation() {
		return teacher_designation;
	}

	public void setTeacher_designation(String teacher_designation) {
		this.teacher_designation = teacher_designation;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_rollNo=" + teacher_rollNo + ", teacher_name=" + teacher_name + ", teacher_address="
				+ teacher_address + ", teacher_dob=" + teacher_dob + ", teacher_standard=" + teacher_standard
				+ ", teacher_designation=" + teacher_designation + "]";
	}
}
	