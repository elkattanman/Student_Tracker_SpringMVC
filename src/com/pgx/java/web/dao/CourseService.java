package com.pgx.java.web.dao;

import java.util.List;

import com.pgx.java.web.bean.Course;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(int id);
}
