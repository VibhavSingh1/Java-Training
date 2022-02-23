package com.thunderdrive.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		
		try {
			if(set != null &&  set.next()) {
				
				user.uid = set.getInt("uid");
				user.name = set.getString("name");
				user.registeredOn = set.getString("registeredOn");
				message = user.name + " Logged in Successfully with UID: " + user.uid + " and registered on: "  + user.registeredOn;
				
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
		buffer.append("</center></body></html>");
		
		//Writing the response to the client
		out.print(buffer.toString());
		
	}
}
