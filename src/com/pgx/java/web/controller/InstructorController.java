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

import com.pgx.java.web.bean.Instructor;
import com.pgx.java.web.dao.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@GetMapping("/list")
	String listInstructors(Model model) {
		List<Instructor> theInstructors = instructorService.getInstructors();
		model.addAttribute("instructors", theInstructors);
		return "list-instructors";
	}

	@GetMapping("/showFormForAdd")
	String showFormForAdd(Model model) {
		Instructor ins = new Instructor();
		model.addAttribute("instructor", ins);
		return "instructor-form";
	}

	@GetMapping("/showFormForUpdate")
	String showFormForUpdate(@RequestParam("instructorId") int instructorId, Model model) {
		Instructor ins = instructorService.getInstructor(instructorId);
		model.addAttribute("instructor", ins);
		return "instructor-form";
	}

	@PostMapping("/saveInstructor")
	public String saveCustomer(@ModelAttribute("instructor") Instructor theInstructor) {

		// save the customer using our service
		instructorService.saveInstructor(theInstructor);

		return "redirect:/instructor/list";
	}
	
	@GetMapping("/delete")
	public String deleteInstructor(@RequestParam("instructorId") int theId) {
		
		// delete the Instructor
		instructorService.deleteInstructor(theId);
		
		return "redirect:/instructor/list";
	}

	@GetMapping("/search")
	public String searchInstructors(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search Instructors from the service
		List<Instructor> theInstructors = instructorService.searchInstructors(theSearchName);
				
		// add the Instructors to the model
		theModel.addAttribute("instructors", theInstructors);

		return "list-instructors";		
	}
}
