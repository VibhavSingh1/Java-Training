package com.thunderdrive.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class DBa {
	
	Connection connection;
	Statement statement;
	
	public DBa()
	{
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("{DB} 1. Driver Loaded");
			String url = "jdbc:mysql://localhost";
			String user = "admin";
			String password = "thunderoov";
			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("{DB} 2. Connection Established");
			
			statement = connection.createStatement();
			System.out.println("{DB} 3. Statement Created");
			
		} catch (Exception e)
		{
			System.err.println("Something went wrong." + e);
		}
		
	}
	
	public int executeSQLStatement(String sql)
	{
		int result = 0;
		try
		{
			result = statement.executeUpdate(sql);
			System.out.println("{DB} 3.2 Statement executed");
			
		} catch (Exception e)
		{
			System.err.println("Something went wrong" + e);
		}
		
		return result;
	}
	
	public void closeConnection()
	{
		try
		{
			connection.close();
			System.out.println("{DB} 4. Connection Closed");
			
		} catch (Exception e)
		{
			System.err.println("Something Went wrong"  + e);
		}
	}
	
}

public class DB
{
	
	public static void main(String [] arg)
	{
		DBa dbq = new DBa();
		dbq.executeSQLStatement("INSERT INTO Practice1.tab1 (id, name) VALUES (101, 'MATH');");
		
		dbq.closeConnection();
	}
	
}

