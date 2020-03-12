package com.pgx.java.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgx.java.web.bean.Instructor;


@Repository
public class InstructorDAOImpl implements InstructorDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Instructor> getInstructors() {
		
		//get current Session
		Session currentSession=sessionFactory.getCurrentSession();
		//create query
		Query<Instructor> query=currentSession.createQuery("From Instructor",Instructor.class);
		//excute query
		List<Instructor> instructors = query.getResultList();
		
		
		return instructors;
	}

	@Override
	public Instructor getInstructor(int id) {
		
		return null;
	}

}
