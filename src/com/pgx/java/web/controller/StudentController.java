package com.pgx.java.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgx.java.web.bean.Student;
import com.pgx.java.web.dao.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/list")
	String ListStudent(Model model) {
		List<Student> theStudents=studentService.getStudents();
		model.addAttribute("students", theStudents);
		
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	String showFormForAdd(Model model) {
		Student st=new Student();
		model.addAttribute("student", st);
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveCustomer(@ModelAttribute("student") Student theStudent) {
		
		// save the customer using our service
		studentService.saveStudent(theStudent);
		
		
		return "redirect:/student/list";
	}
}
