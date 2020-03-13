package com.pgx.java.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgx.java.web.bean.Course;
import com.pgx.java.web.bean.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorDAO courseDOA;
	
	@Override
	@Transactional
	public List<Instructor> getInstructors() {
		return courseDOA.getInstructors();
	}

	@Override
	@Transactional
	public Instructor getInstructor(int id) {
		// TODO Auto-generated method stub
		return courseDOA.getInstructor(id);
	}

}
