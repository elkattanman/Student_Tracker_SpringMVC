package com.pgx.java.web.dao;

import java.util.List;

import com.pgx.java.web.bean.Instructor;

public interface InstructorService {
	public List<Instructor> getInstructors();
	public Instructor getInstructor(int id);
}
