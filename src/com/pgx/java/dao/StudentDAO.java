package com.pgx.java.dao;

import java.util.List;

import com.pgx.java.bean.Student;

public interface StudentDAO {
	public List<Student> getStudents();
	public Student getStudent(int id);
}
