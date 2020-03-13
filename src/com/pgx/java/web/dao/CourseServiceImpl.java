package com.pgx.java.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgx.java.web.bean.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDOA;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		return courseDOA.getCourses();
	}

	@Override
	@Transactional
	public Course getCourse(int id) {
		// TODO Auto-generated method stub
		return courseDOA.getCourse(id);
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		courseDOA.saveCourse(theCourse);
	}

}
