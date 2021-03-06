package com.pgx.java.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgx.java.web.bean.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDOA;

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDOA.getStudents();
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		Student student = studentDOA.getStudent(id);
		return student;
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentDOA.saveStudent(theStudent);
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
		studentDOA.deleteStudent(theId);
	}

	@Override
	@Transactional
	public List<Student> searchStudents(String theSearchName) {
		return studentDOA.searchStudents(theSearchName);
	}

}
