package org.virtusa.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.virtusa.entities.Student;
import org.virtusa.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	@RequestMapping("/show")
	public String showStudentForm(Model model) {
		Student student=new Student();
		//student.setName("suresh");
		//student.setAddress("Chennai");
		model.addAttribute("student",student);
		return "student-form";
	}
	/*@RequestMapping(value="/students",method=RequestMethod.GET)
	public String showStudents(Model model) {
		List<Student> students=studentService.getStudents();
		model.addAttribute("students", students);
		return "home";
	}*/
	/*@RequestMapping(value="/students",method=RequestMethod.GET)
	public ModelAndView showStudents() {
		List<Student> students=studentService.getStudents();
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("students", students);
		return mv;
	}*/
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public String showStudents(ModelMap modelMap) {
		List<Student> students=studentService.getStudents();
		modelMap.addAttribute("students", students);
		return "home";
	}
	/*@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addStudent(@RequestParam("name") String name,@RequestParam("address") String address,
			@RequestParam("dob") String dob) {
		
		  String name=request.getParameter("name"); String
		  address=request.getParameter("address"); String
		  dob=request.getParameter("dob");
		 
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateOfBirth = LocalDate.parse( dob , f ); 
		Student st=new Student();
		st.setName(name);
		st.setAddress(address);
		st.setDateOfBirth(dateOfBirth);
		studentService.insertStudent(st);
		return "redirect:/students";		
	}*/
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.insertStudent(student);
		return "redirect:/students";
		
	}
	
}
