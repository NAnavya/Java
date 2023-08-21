package org.virtusa.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.virtusa.entities.Emp;
import org.virtusa.services.EmployeeService;
import org.virtusa.services.EmployeeServiceImpl;

@WebServlet("/employees")
public class DisplayEmployeeController extends HttpServlet{
	EmployeeService employeeService=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Emp> employees=employeeService.getEmployees();
		req.setAttribute("employees", employees);
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
}
