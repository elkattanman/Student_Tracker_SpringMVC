package com.pgx.java.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgx.java.web.bean.Instructor;
import com.pgx.java.web.dao.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	InstructorService instructorService;
	
	@GetMapping("/list")
	String listInstructors(Model model) {
		List<Instructor> theInstructors= instructorService.getInstructors();
		model.addAttribute("instructors", theInstructors);
		return "list-instructors";
	}
	
	
	@GetMapping("/showFormForAdd")
	String showFormForAdd(Model model) {
		Instructor ins=new Instructor();
		model.addAttribute("instructor", ins);
		return "instructor-form";
	}
	
	@PostMapping("/saveInstructor")
	public String saveCustomer(@ModelAttribute("instructor") Instructor theInstructor) {
		
		// save the customer using our service
		instructorService.saveInstructor(theInstructor);
		
		
		return "redirect:/instructor/list";
	}
}
