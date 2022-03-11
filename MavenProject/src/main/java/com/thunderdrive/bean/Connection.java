package com.thunderdrive.bean;

//Bean is just like the model with mandatory presence of Getters and Setters(both must be Public).
//Bean is a POJO class only and is terminology is the Spring FW.

public class Connection {
	
	//Attributes
	String url;
	String username;
	String password;
	
	
	public Connection()
	{
		System.out.println("[Connection] Object created by default constructor");
	}
	
	public Connection(String url, String username, String password) {
		super();
		System.out.println("[Connection] Object created by parameterized constructor.");
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Connection [url=" + url + ", username=" + username + ", password=" + password + "]";
	}
	
	
	//Mandatory and Public 
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// User defined methods and can be any name
	// But signature goes as void and no input
	
	public void myInit() {
		System.out.println("[Connection] myInit executed");
	} 
	
	public void myDestroy() {
		System.out.println("[Connection] myDestory executed");
	}
	

}
