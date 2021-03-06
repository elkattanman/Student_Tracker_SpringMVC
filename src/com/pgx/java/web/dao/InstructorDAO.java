package com.pgx.java.web.dao;

import java.util.List;

import com.pgx.java.web.bean.Instructor;


public interface InstructorDAO {
	public List<Instructor> getInstructors();
	public Instructor getInstructor(int id);
	public void saveInstructor(Instructor theInstructor);
	public List<Instructor> searchInstructors(String theSearchName);
	public void deleteInstructor(int theId);
}
