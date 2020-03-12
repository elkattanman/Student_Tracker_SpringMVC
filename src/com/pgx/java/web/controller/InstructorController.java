package com.pgx.java.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgx.java.web.bean.Instructor;
import com.pgx.java.web.dao.InstructorDAO;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	InstructorDAO instructorDAO;
	
	@RequestMapping("/list")
	String listInstructors(Model model) {
		List<Instructor> theInstructors= instructorDAO.getInstructors();
		model.addAttribute("instructors", theInstructors);
		return "list-instructors";
	}
}
