package com.pgx.java.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgx.java.web.bean.Student;
import com.pgx.java.web.dao.StudentDAO;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentDAO studentDOA;
	
	@RequestMapping("/list")
	String ListStudent(Model model) {
		List<Student> theStudents=studentDOA.getStudents();
		model.addAttribute("students", theStudents);
		
		return "list-students";
	}
}
