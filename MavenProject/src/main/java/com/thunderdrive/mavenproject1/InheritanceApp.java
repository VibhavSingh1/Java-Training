package com.thunderdrive.mavenproject1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thunderdrive.bean.Pizza;

public class InheritanceApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("inheritance.xml");
		Pizza pizza = context.getBean("pRef", Pizza.class);
		
		System.out.println("PIZZA DETAILS");
		System.out.println(pizza); 
		

	}

}
