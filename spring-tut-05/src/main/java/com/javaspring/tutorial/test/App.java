package com.javaspring.tutorial.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/javaspring/tutorial/beans/beans.xml");

		Robot robot = (Robot) context.getBean("robot");
		robot.speak();

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDAO");
		
		Offers updateOffers = new Offers(9,"Chrono","chrono7363@hotmail.com","Css webdesign");
		if(offersDao.update(updateOffers)) {
			System.out.println("Object updated");
		} 
		else {
			System.out.println("Cannot be updated");
		}
		
		try {
			
			/*Offers offers1 = new Offers("Frank", "frank8748@aol.com", "Angular js web developer");
			Offers offers2 = new Offers("Chrono", "chronoty321@aol.com", "Java coder");
			
			if(offersDao.create(offers1)) {
				System.out.println("Created offer object");
			}
			
			if(offersDao.create(offers2)) {
				System.out.println("Created offer object");
			}*/
			
			List<Offers> batchOffers = new ArrayList<Offers>();
			batchOffers.add(new Offers("Luffy","luffy737@yahoo.com","Project related help"));
			batchOffers.add(new Offers("Glenn","glennfroggy@yahoo.com","Database related work"));
			int [] rvals = offersDao.create(batchOffers);
			for(int value: rvals) {
				System.out.println("Updated " + value + " rows.");
			}
			
			//offersDao.delete(11);
			
			List<Offers> offers = offersDao.getOffers();
			for (Offers offer : offers) {
				System.out.println(offer);
			}
			
			Offers offer = offersDao.getUserOffers(2);
			System.out.println("Name is: "+ offer.getName() + " and offer is : " + offer);

		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
