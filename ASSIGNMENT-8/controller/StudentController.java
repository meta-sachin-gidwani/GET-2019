package com.metacube.assignment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.assignment.model.Student;

@Controller
public class StudentController {
	@Value("${welcome.message}")
	private String welcomeMessage;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}

	@PostMapping("/addStudentDone")
	public String addStudentDone(@Validated Student stu, BindingResult result) {
		if (result.hasErrors()) {
			result.addError(new ObjectError("message",
					"please fill all fields properly"));
			return "addStudent";
		} else
			System.out.println(stu);
		return "redirect:/home";
	}

	@GetMapping("/showStudents")
	public String showStudents() {
		return "showStudents";
	}
}
