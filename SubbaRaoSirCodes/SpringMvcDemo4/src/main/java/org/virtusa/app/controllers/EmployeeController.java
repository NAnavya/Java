package org.virtusa.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.virtusa.app.entities.Emp;
import org.virtusa.app.services.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		List<Emp> employees=employeeService.getEmployees();
		model.addAttribute("employees", employees);
		return "home";
	}
	@GetMapping("/show")
	public String showForm(Model model) {
		Emp e=new Emp();
		model.addAttribute("emp", e);
		return "emp-form";
	}
	@PostMapping("/process")
	public String addEmployee(@Valid @ModelAttribute("emp") Emp e,BindingResult result) {
		if(result.hasErrors()) {
			return "emp-form";
		}
		employeeService.insertEmployee(e);
		return "redirect:/employees";
	}
	@GetMapping("/delete/{eno}")
	public String deleteEmployee(@PathVariable("eno") int eno) {
		employeeService.deleteEmployee(eno);
		return "redirect:/employees";
	}
	@GetMapping("/update")
	public String showEmployeeForm(@RequestParam("eno") int eno,Model model) {
		Emp e=employeeService.getEmployee(eno);
		model.addAttribute("emp",e);
		return "emp-form";
	}
}
