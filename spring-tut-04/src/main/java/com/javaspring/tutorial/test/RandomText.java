package com.javaspring.tutorial.test;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomText {
	
	private static String[] texts = {
		"This is java's SPEL tutorial",
		"SPEL is just like J2EE EL",
		"SPEL : Spring Expression Language"
	};
	
	public String getText() {
		Random random = new Random();
		
//		return null;
		return texts[random.nextInt(texts.length)];
	}
}
