package org.virtusa.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.virtusa.dao.UserDao;
import org.virtusa.dao.UserDaoImpl;
import org.virtusa.entities.User;


@WebServlet("/login")
public class UserController extends HttpServlet{
	UserDao dao=new UserDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		if(dao.validateUser(user))
		{
			HttpSession session=req.getSession();
			session.setAttribute("user",user);
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "Invalid User Credentials");
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
}
