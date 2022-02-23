package com.thunderdrive.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.thunderdrive.db.DB;
import com.thunderdrive.model.User;


public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DB db;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[RegisterServlet] - init");
		db = DB.getDB();
	}

	
	public void destroy() {
		System.out.println("[RegisterServlet] - destroy");
		db.closeConnection();
	}
	
	//handles both get and post request from the client.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[RegisterServlet] - service");
		
		//In service method, we have HttpServletRequest object form which we can extract data
		// 1. Create User Object.
		
		User user = new User();
		user.name = request.getParameter("txtName");
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		
		System.out.println("[RegisterServlet]" + user);
		
		String sql = user.insertSQL();
		System.out.println("[RegisterServlet]" + sql);
		
		
		
		//3. Save the Data in DataBase
		int result = db.executeUpdate(sql);
		//int result = db.executeUpdate("insert into User values (null, '"+ user.name + "', '" + user.email.toString() + "', '" + user.password + "', '" + user.registeredOn + "')");
		String message = result > 0 ? "Thank You for Your Registration: " + user.name : "Registration Failed: " + user.name;
		
		//4. Use the HttpServletResponse to send text or HTML back to the client
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); // PrintWriter Object will write the response back to client
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><body><center>");
		buffer.append("<h3>" + message + "</h3>");
		buffer.append("<p>Registered On: " + user.registeredOn + "</p>");
		buffer.append("</center></body></html>");
		
		//Writing the response to the client
		out.print(buffer.toString());
		
	}

}
