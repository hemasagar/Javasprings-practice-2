package com.javaspring.tutorial;

import java.io.FilePermission;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/javaspring/tutorial/beans/beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/javaspring/tutorial/beans/beans.xml");
		
		Person person1 = (Person) context.getBean("person");
//		Person person2 = (Person) context.getBean("person");
		
		person1.setTaxId(999);
		
		Address address2 = (Address) context.getBean("address2");
		System.out.println(address2);
		
		System.out.println(person1);
		
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
