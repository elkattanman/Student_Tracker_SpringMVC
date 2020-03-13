package com.pgx.java.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgx.java.web.bean.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Instructor> getInstructors() {

		// get current Session
		Session currentSession = sessionFactory.getCurrentSession();
		// create query
		Query<Instructor> query = currentSession.createQuery("From Instructor", Instructor.class);
		// excute query
		List<Instructor> instructors = query.getResultList();

		return instructors;
	}

	@Override
	public Instructor getInstructor(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Instructor instructor = currentSession.get(Instructor.class, id);
		return instructor;
	}

	@Override
	public void saveInstructor(Instructor theInstructor) {
		Session currentSession = sessionFactory.getCurrentSession();

//		currentSession.save(theInstructor);
		currentSession.saveOrUpdate(theInstructor);

	}

}
