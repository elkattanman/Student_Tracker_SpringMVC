package com.pgx.java.web.dao;

import java.util.List;

import com.pgx.java.web.bean.Student;

public interface StudentService {
	public List<Student> getStudents();
	public Student getStudent(int id);
	public void saveStudent(Student theStudent);
}
