package com.pgx.java.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgx.java.web.bean.Course;
import com.pgx.java.web.dao.CourseDAO;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseDAO courseDAO;

	@RequestMapping("/list")
	String ListStudent(Model model) {
		List<Course> thecourses = courseDAO.getCourses();
		model.addAttribute("students", thecourses);

		return "list-courses";
	}

}
