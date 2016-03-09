package com.javaspring.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/javaspring/tutorial/beans/beans.xml");
		Logger logger = (Logger)context.getBean("logger");
		
		logger.writeConsole("Hello World!");
		logger.writeFile("Good Morning");
		
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
