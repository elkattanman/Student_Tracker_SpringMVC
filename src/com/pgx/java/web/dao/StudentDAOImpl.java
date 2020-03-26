package com.pgx.java.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgx.java.web.bean.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		// get Current Session from session Factory
		Session currentSession = sessionFactory.getCurrentSession();
		// create Queary
		Query<Student> query = currentSession.createQuery("from Student", Student.class);
		// excute query
		List<Student> students = query.getResultList();

		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public Student getStudent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class, id);
		return student;
	}

	@Override
	public void saveStudent(Student theStudent) {
		Session currentSession = sessionFactory.getCurrentSession();

//		currentSession.save(theStudent);
		currentSession.saveOrUpdate(theStudent);

	}

	@Override
	public void deleteStudent(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public List<Student> searchStudents(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Student> theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery(
					"from Student where lower(firstName) like :theName or lower(lastName) like :theName",
					Student.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		} else {
			// theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("from Student", Student.class);
		}

		// execute query and get result list
		List<Student> students = theQuery.getResultList();

		// return the results
		return students;
	}

}
