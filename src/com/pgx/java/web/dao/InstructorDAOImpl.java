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

	@Override
	public List<Instructor> searchInstructors(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Instructor> theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery(
					"from Instructor where lower(firstName) like :theName or lower(lastName) like :theName",
					Instructor.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		} else {
			// theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("from Instructor", Instructor.class);
		}

		// execute query and get result list
		List<Instructor> instructors = theQuery.getResultList();

		// return the results
		return instructors;
	}

	@Override
	public void deleteInstructor(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Instructor where id=:instructorId");
		theQuery.setParameter("instructorId", theId);

		theQuery.executeUpdate();
	}

}
