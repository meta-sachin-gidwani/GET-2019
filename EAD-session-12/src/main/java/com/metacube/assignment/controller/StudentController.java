package com.metacube.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.assignment.dto.Std;
import com.metacube.assignment.dto.StudentForm;
import com.metacube.assignment.model.Student;
import com.metacube.assignment.repository.StudentRepository;
import com.metacube.assignment.util.DTOUtil;

@Controller
public class StudentController {

	@Value("${welcome.message}")
	private String welcomeMessage;

	private StudentRepository studentRepo;

	@Autowired
	public StudentController(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}

	@GetMapping("/studentList")
	public String studentList(Model model) {
		List<Student> studentList = studentRepo.findAll();
		model.addAttribute("studentList", studentList);
		return "studentList";
	}

	@GetMapping("/addStudent")
	public String studentAdd(Model model) {
		model.addAttribute(new StudentForm());
		return "addStudent";
	}

	@PostMapping("/addStudent")
	public String studentAdded(@Validated StudentForm studentForm,
			BindingResult result, RedirectAttributes attributes) {
		if (!result.hasErrors()) {
			if (studentRepo.findByEmailContainingIgnoreCase(
					DTOUtil.map(studentForm, Student.class)).size() == 0) {
				studentRepo.save(DTOUtil.map(studentForm, Student.class));
				attributes.addFlashAttribute("msg", "Student Added");
				return "redirect:/home";
			} else
				result.addError(new ObjectError("msg", "Student already exist"));
		}
		return "addStudent";
	}

	@GetMapping("/searchStudent")
	public String searchStudent(Model model) {
		model.addAttribute(new Std());
		return "searchStudent";
	}

	@PostMapping("/searchStudent")
	public String studentSearch(@Validated Std std, BindingResult result,
			RedirectAttributes attributes, Model model) {
		if (!result.hasErrors()) {
			List<Student> studentList = studentRepo
					.findByStdContainingIgnoreCase(std.getStd());
			if (studentList.size() > 0) {
				model.addAttribute("studentList", studentList);
				return "studentList";
			} else
				result.addError(new ObjectError("msg", "No student Found"));
		}
		return "searchStudent";
	}
}
