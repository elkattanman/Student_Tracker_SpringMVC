package com.pgx.java.dao;

import java.util.List;

import com.pgx.java.bean.Course;
import com.pgx.java.bean.Student;

public interface CourseDAO {
	public List<Course> getCourses();
	public Course getCourse(int id);
}
