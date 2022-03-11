package com.thunderdrive.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	
	public int uid;
	public String name;
	public String email;
	public String password;
	public String registeredOn;
	public String sql;
	
	public User()
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		registeredOn = formatter.format(date);
	}
	
	public User(int uid, String name, String email, String password, String registeredOn) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.registeredOn = registeredOn;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", password=" + password + ", registeredOn="
				+ registeredOn + "]";
	}
	
	public String insertSQL()
	{
		return "insert into User values (null, '"+ this.name + "', '" + this.email + "', '" + this.password + "', '" + this.registeredOn + "')";
		
	}
	
	public String selectSQL()
	{
		return "select * from User where email = '" + email +  "' and password = '" + password + "'";
 	}
}
