package com.pgx.java.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgx.java.web.bean.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Course> getCourses() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Course> query = currentSession.createQuery("From Course", Course.class);
		
		List<Course> courses=query.getResultList();

		return courses;
	}

	@Override
	public Course getCourse(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
