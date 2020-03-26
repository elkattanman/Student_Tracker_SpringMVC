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

import com.pgx.java.web.bean.Course;
import com.pgx.java.web.dao.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/list")
	String ListCourse(Model model) {
		List<Course> thecourses = courseService.getCourses();
		model.addAttribute("courses", thecourses);
		return "list-courses";
	}

	@GetMapping("/showFormForAdd")
	String showFormForAdd(Model model) {
		Course c = new Course();
		model.addAttribute("course", c);
		return "courses-form";
	}
	@GetMapping("/showFormForUpdate")
	String showFormForUpdate(@RequestParam("courseId") int courseId, Model model) {
		Course c = courseService.getCourse(courseId);
		model.addAttribute("course", c);
		return "courses-form";
	}

	@PostMapping("/saveCourse")
	public String saveCustomer(@ModelAttribute("course") Course theCourse) {

		// save the customer using our service
		courseService.saveCourse(theCourse);

		return "redirect:/course/list";
	}
	
	@GetMapping("/delete")
	public String deleteCourse(@RequestParam("courseId") int theId) {
		
		// delete the Course
		courseService.deleteCourse(theId);
		
		return "redirect:/course/list";
	}

	@GetMapping("/search")
	public String searchCourses(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search Courses from the service
		List<Course> theCourses = courseService.searchCourses(theSearchName);
				
		// add the Courses to the model
		theModel.addAttribute("courses", theCourses);

		return "list-courses";		
	}

}
