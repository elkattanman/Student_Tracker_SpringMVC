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
		//get Current Session from session Factory
		Session currentSession=sessionFactory.getCurrentSession();
		//create Queary
		Query<Student> query = currentSession.createQuery("from Student" , Student.class);
		//excute query
		List<Student> students=query.getResultList();
		
		// TODO Auto-generated method stub
		return students;
	}
	
	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveStudent(Student theStudent) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.save(theStudent);
		
	}

}
