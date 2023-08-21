package org.virtusa.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.virtusa.entities.Emp;
import org.virtusa.services.EmployeeService;
import org.virtusa.services.EmployeeServiceImpl;

@WebServlet("/add")
public class AddEmployeeController extends HttpServlet{
	EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eno=Integer.parseInt(req.getParameter("eno"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		Emp e=new Emp(eno, name, address);
		service.insertEmployee(e);
		resp.sendRedirect("./employees");
	}
}
