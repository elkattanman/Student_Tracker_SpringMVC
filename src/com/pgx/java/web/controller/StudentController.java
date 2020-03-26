package com.pgx.java.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pgx.java.web.bean.Student;
import com.pgx.java.web.dao.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/list")
	String ListStudent(Model model) {
		List<Student> theStudents = studentService.getStudents();
		model.addAttribute("students", theStudents);

		return "list-students";
	}

	@GetMapping("/showFormForAdd")
	String showFormForAdd(Model model) {
		Student st = new Student();
		model.addAttribute("student", st);
		return "student-form";
	}

	@GetMapping("/showFormForUpdate")
	String showFormForUpdate(@RequestParam("studentId") int studentId, Model model) {
		Student st = studentService.getStudent(studentId);
		model.addAttribute("student", st);
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {

		// save the student using our service
		studentService.saveStudent(theStudent);

		return "redirect:/student/list";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		
		// delete the student
		studentService.deleteStudent(theId);
		
		return "redirect:/student/list";
	}

	@GetMapping("/search")
	public String searchStudents(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search students from the service
		List<Student> theStudents = studentService.searchStudents(theSearchName);
				
		// add the students to the model
		theModel.addAttribute("students", theStudents);

		return "list-students";		
	}
}
