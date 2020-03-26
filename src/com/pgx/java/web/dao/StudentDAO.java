package com.pgx.java.web.dao;

import java.util.List;

import com.pgx.java.web.bean.Student;

public interface StudentDAO {
	public List<Student> getStudents();
	public Student getStudent(int id);
	public void saveStudent(Student theStudent);
	public void deleteStudent(int theId);
	public List<Student> searchStudents(String theSearchName);
	
}
