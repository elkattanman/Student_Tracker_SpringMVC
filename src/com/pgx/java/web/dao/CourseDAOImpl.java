package com.pgx.java.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgx.java.web.bean.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Course> getCourses() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Course> query = currentSession.createQuery("From Course", Course.class);

		List<Course> courses = query.getResultList();

		return courses;
	}

	@Override
	public Course getCourse(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Course course = currentSession.get(Course.class, id);
		return course;
	}

	@Override
	public void saveCourse(Course theCourse) {
		Session currentSession = sessionFactory.getCurrentSession();

//		currentSession.save(theCourse);
		currentSession.saveOrUpdate(theCourse);
	}

	@Override
	public List<Course> searchCourses(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Course> theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery(
					"from Course where lower(firstName) like :theName or lower(lastName) like :theName",
					Course.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		} else {
			// theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("from Course", Course.class);
		}

		// execute query and get result list
		List<Course> courses = theQuery.getResultList();

		// return the results
		return courses;
	}

	@Override
	public void deleteCourse(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Course where id=:courseId");
		theQuery.setParameter("courseId", theId);

		theQuery.executeUpdate();
	}

}
