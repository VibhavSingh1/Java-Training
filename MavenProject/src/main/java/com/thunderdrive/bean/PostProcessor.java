package com.thunderdrive.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor {
	 
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("[PostProcessor] - BEFORE" + beanName);
		
		Connection con = (Connection)bean;
		System.out.println("Before Connection Username is: "+con.username);
		con.setPassword("password123456");
		
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("[PostProcessor] - AFTER" + beanName);
		
		Connection con = (Connection)bean;
		System.out.println("After Connection username is: "+con.username);
		
		String password = con.getPassword();
		// Securing the password further
		con.setPassword(password.replace('s', 'q'));
		
		return bean;
	}
	
	

}
