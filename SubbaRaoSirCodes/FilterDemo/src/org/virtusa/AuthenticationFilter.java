package org.virtusa;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName="filter1")
public class AuthenticationFilter implements Filter {
	FilterConfig config;
 
	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("ksrao")&&password.equals("ksrao@123")) {
			System.out.println(config.getInitParameter("name")+"\t"+config.getInitParameter("address"));
			chain.doFilter(request, response);
		}
		else
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
	}

}
