package com.pgx.java.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pgx.java.web.bean.Person;

@Controller
public class MyController {
    @GetMapping("/Hello")
    public String helloView(Model model) {
        
        Person p = new Person("DR","Mustafa","Khaled");
        model.addAttribute("person", p);
    
        return "HelloWorld";
    }
}
