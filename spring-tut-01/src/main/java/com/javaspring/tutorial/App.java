package com.javaspring.tutorial;

import java.io.FilePermission;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/javaspring/tutorial/beans/beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/javaspring/tutorial/beans/beans.xml");
		
		Person person = (Person) context.getBean("person");
		person.speak();
		((ClassPathXmlApplicationContext)context).close();
	}

}
