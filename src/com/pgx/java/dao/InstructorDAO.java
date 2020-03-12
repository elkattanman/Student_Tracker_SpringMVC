package com.pgx.java.dao;

import java.util.List;

import com.pgx.java.bean.Instructor;


public interface InstructorDAO {
	public List<Instructor> getInstructors();
	public Instructor getInstructor(int id);
}
