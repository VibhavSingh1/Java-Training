package com.thunderdrive.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.thunderdrive.db.DB;
import com.thunderdrive.model.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DB db;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[LoginServlet] - init");
		db = DB.getDB();
		
	}

	public void destroy() {
		System.out.println("[LoginServlet] - destroy");
		db.closeConnection();
	}

	// doPost will work only when it's a post request from the client, will handle only post request.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LoginServlet] - doPost");
		
		User user = new User();
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		
		String sql = user.selectSQL();
		System.out.println("[LoginServlet] " + user);
		System.out.println("[LoginServlet] " + sql);

		ResultSet set = db.executeQuery(sql);
		 
		String message = "";
		String urlToHome = "";
		String hiddenFormFieldsData = "";
		
		try {
			if(set != null &&  set.next()) {
				
				user.uid = set.getInt("uid");
				user.name = set.getString("name");
				user.registeredOn = set.getString("registeredOn");
				
				 
				message = user.name + " Logged in Successfully with UID: " + user.uid + " and registered on: "  + user.registeredOn;
				
				//2. Session Tracking with URL Rewriting 
				String queryString = "Welcome?name=" + user.name + "&email=" + user.email + "&uid=" + user.uid;
				
				urlToHome = "<p><a href='"+queryString+"'>Click to Navigate to Home</a></p>";
				
				//1. Session Tracing with Cookies  - Write the data
				//Cookie cookie1 = new Cookie("keyName", String.valueOf(user.name));
				Cookie cookie2 = new Cookie("keyEmail", String.valueOf(user.email));
				Cookie cookie3 = new Cookie("keyUid", String.valueOf(user.uid));
				
				//response.addCookie(cookie1);
				response.addCookie(cookie2);
				response.addCookie(cookie3); 
				//response.sendRedirect("Welcome");
				
				
				//3. HttpSession Session Tracking method 
				HttpSession session = request.getSession();
				session.setAttribute("keyUser", user);//complete user object dumped in.
				
				
				 //4. Hidden Form Fields Session tracking method.
				hiddenFormFieldsData = "<form action='Welcome' method='post'>"
						+ "<input type='hidden' name='txtName' value='" + user.name + "'>"
						+ "<input type='hidden' name='txtEmail' value='" + user.email + "'>"
						+ "<input type='hidden' name='txtUid' value='" + user.uid + "'>"
						+ "<input type='submit' value='NAVIGATE TO HOME'>"
						+ "</form>";
				
			} else 
			{
				message = user.email + "Invalid Login Credentials. Please Try Again";
			}
		} catch (Exception e)
		{
			System.out.println("[LoginServlet] "  + e);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<html><body><center>");
		buffer.append("<h3>" + message + "</h3>");
		buffer.append(urlToHome);
		buffer.append(hiddenFormFieldsData);
		buffer.append("</center></body></html>");
		
		//Writing the response to the client
		out.print(buffer.toString());
		 
	}
}
