package com.pgx.java.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgx.java.web.bean.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorDAO intructorDOA;
	
	@Override
	@Transactional
	public List<Instructor> getInstructors() {
		return intructorDOA.getInstructors();
	}

	@Override
	@Transactional
	public Instructor getInstructor(int id) {
		// TODO Auto-generated method stub
		return intructorDOA.getInstructor(id);
	}

	@Override
	@Transactional
	public void saveInstructor(Instructor theInstructor) {
		intructorDOA.saveInstructor(theInstructor);
		
	}

	@Override
	@Transactional
	public void deleteInstructor(int theId) {
		intructorDOA.deleteInstructor(theId);
		
	}

	@Override
	@Transactional
	public List<Instructor> searchInstructors(String theSearchName) {
		return intructorDOA.searchInstructors(theSearchName);
	}

}
