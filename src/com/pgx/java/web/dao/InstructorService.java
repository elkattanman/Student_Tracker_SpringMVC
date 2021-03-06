package com.pgx.java.web.dao;

import java.util.List;

import com.pgx.java.web.bean.Instructor;

public interface InstructorService {
	public List<Instructor> getInstructors();
	public Instructor getInstructor(int id);
	public void saveInstructor(Instructor theInstructor);
	public void deleteInstructor(int theId);
	public List<Instructor> searchInstructors(String theSearchName);
}
