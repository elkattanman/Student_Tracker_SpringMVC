package com.pgx.java.web.dao;

import java.util.List;

import com.pgx.java.web.bean.Student;

public interface StudentDAO {
	public List<Student> getStudents();
	public Student getStudent(int id);
}