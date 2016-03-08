package com.javaspring.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/javaspring/tutorial/beans/beans.xml");
		
		Jungle jungle = (Jungle) context.getBean("jungle");
		System.out.println(jungle);
		
		Jungle1 jungle1 = (Jungle1) context.getBean("jungle1");
		System.out.println(jungle1);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
