package org.virtusa.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.virtusa.services.EmployeeService;
import org.virtusa.services.EmployeeServiceImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eno=Integer.parseInt(req.getParameter("eno"));
		System.out.println(eno);
		service.deleteEmployee(eno);
		resp.sendRedirect("./employees");
	}
}
