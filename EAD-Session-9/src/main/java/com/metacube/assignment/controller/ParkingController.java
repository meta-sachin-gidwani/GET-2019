package com.metacube.assignment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.assignment.dto.EmployeeForm;
import com.metacube.assignment.dto.VehicleForm;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Employee;
import com.metacube.assignment.model.Image;
import com.metacube.assignment.model.Pass;
import com.metacube.assignment.service.EmployeeService;

@Controller
public class ParkingController {

	private HttpSession session;
	@Autowired
	private EmployeeService empService;
	@Value("${welcome.message}")
	private String welcomeMessage;
	private List<Employee> friendList;

	@GetMapping("/registrationPage")
	public String registration(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute(new EmployeeForm());
		return "registration";
	}

	@PostMapping("/registrationPage")
	public String registerEmployee(@Validated EmployeeForm emp,
			BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors())
			return "registration";
		else {
			if (!empService.isEmpExist(emp.getEmail())) {
				if (emp.getPassword().equals(emp.getConfirmPassword())) {
					empService.registerEmployee(emp);
					attributes.addAttribute("empId", emp.getEmail());
					return "redirect:/addVehiclePage";
				} else
					result.addError(new ObjectError("passwordValidation",
							"password does not match"));
			} else
				result.addError(new ObjectError("EmployeeValidation",
						"Employee already registered"));
			return "/registration";
		}
	}

	@GetMapping("/addVehiclePage")
	public String addVehicle(@RequestParam("empId")String empId,Model model) {
		model.addAttribute("empId",empId);
		model.addAttribute(new VehicleForm());
		return "addVehicle";
	}

	@PostMapping("/addVehiclePage")
	public String vehicleAdded(@Validated VehicleForm vehicle,
			BindingResult result, Model model, RedirectAttributes attributes) {
		if (!result.hasErrors()
				&& empService.addVehicle(vehicle) == Status.ADDED) {
			attributes.addAttribute("vehicleType",
					vehicle.getVehicleType());
			attributes.addAttribute("empId", vehicle.getEmpId());
			return "redirect:/passDetailPage";
		}
		return "/addVehicle";
	}

	@GetMapping("/passDetailPage")
	public String passDetail(@RequestParam("empId")String empId,@RequestParam("vehicleType")String vehicleType,Model model) {
		model.addAttribute("empId",empId);
		model.addAttribute("vehicleType",vehicleType);
		model.addAttribute(new Pass());
		return "passDetail";
	}

	@PostMapping("/passDetailPage")
	public String passAdded(Pass pass, BindingResult result,
			HttpServletRequest request) {
		Image img = new Image(pass.getEmpId(), "no image");
		if (empService.addPass(pass) == Status.ADDED
				&& empService.setImage(img) == Status.ADDED) {
			HttpSession session=request.getSession();
			session.setAttribute("empId", pass.getEmpId());
			return "redirect:/homePage";
		} else
			return "/passDetail";
	}

	@GetMapping("/homePage")
	public String home(Model model) {
		Employee employee = empService.getEmpByEmail((String)session.getAttribute("empId"));
		model.addAttribute("emp",employee);
		return "home";
	}

	@GetMapping("/loginPage")
	public String login(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute(new EmployeeForm());
		return "login";
	}

	@PostMapping("/loginPage")
	public String authentication(EmployeeForm emp, BindingResult result,
			Model model,HttpServletRequest request) {
		if (empService.isEmpExist(emp.getEmail())) {
			if (emp.getPassword().equals(
					empService.getPasswordByEmail(emp.getEmail()))) {
				session=request.getSession();
				session.setAttribute("empId", emp.getEmail());
				return "redirect:/homePage";
			} else
				result.addError(new ObjectError("passwordValidation",
						"Invalid email or password"));
		}
		return "/login";
	}

	@GetMapping("/friendList")
	public String friendList(Employee emp, BindingResult result, Model model) {
		friendList = empService.getFriendList(emp.getEmail());
		model.addAttribute("friendList", friendList);
		return "friendList";
	}

	@GetMapping("/friendProfile")
	public String showFriendProfile(Employee emp, BindingResult result,
			Model model) {
		Employee employee = empService.getEmpByEmail(emp.getEmail());
		model.addAttribute("emp", employee);
		return "friendDetail";
	}

	@GetMapping("/imageChange")
	public String imageUpload( Model model) {
		model.addAttribute("empId", (String)session.getAttribute("empId"));
		model.addAttribute("image", new Image());
		return "imageUpload";
	}

	@GetMapping("/imageUpload")
	public String changeImage(Image img, Model model) {
		empService.updateImage(img);
		return "redirect:/homePage";
	}
	
	@GetMapping("/update")
	public String updateDetail(Employee emp, BindingResult result, Model model) {
		    empService.updateDetail(emp);
			return "redirect:/homePage";
	}
	
	@GetMapping("/logout")
	public String logOut(Model model,RedirectAttributes attributes,HttpServletRequest request) {
		session=request.getSession();
		if(!session.getAttribute("empId").equals(null)){
			session.removeAttribute("empId");
			session.invalidate();
		attributes.addFlashAttribute("message", "successfully Logout");
		return "redirect:/loginPage";
		}
		return "redirect:/home";
	}
}
