package com.thunderdrive.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.thunderdrive.model.User;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><body><center>");
		buffer.append("<h3> Welcome to Home Dear User</h3>");
		buffer.append("<p> Its:" + new Date() + "</p>");
		
		/*String name = request.getParameter("name");
		String email = request.getParameter("email");
		String uid = request.getParameter("uid");*/
		
		
		String name = request.getParameter("txtName");
		String email = request.getParameter("txtEmail");
		String uid = request.getParameter("txtUid");
		
		
		
		//get all the cookies from the browser which are stored locally in it.
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie: cookies) {
			
			buffer.append("<p><b>[Cookie] " + cookie.getName() + " | " + cookie.getValue() + "</b></p>");
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("keyUser");
		
		buffer.append("<p><b>[URL REWRITING] USER DETAIL: " + uid + " | " + name + " | " + email + "</b></p>");
		buffer.append("<p><b>[HTTP SESSION] USER DETAIL: " + user.uid + " | " + user.name + " | " + user.email + " | "+ user.registeredOn + "</b></p>");
		buffer.append("</center></body></html>");
		out.print(buffer.toString());
			 
	}

}
