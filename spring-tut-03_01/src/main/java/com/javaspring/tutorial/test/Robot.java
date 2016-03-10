package com.javaspring.tutorial.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	private int id= 0;
	private String speech = "hello";
	
	@Autowired
	public void setId(@Value("2020")int id) {
		this.id = id;
	}
	
	@Autowired
	public void setSpeech(@Value("Beep beep...")String speech) {
		this.speech = speech;
	}
	
	public void speak() {
		System.out.println(id + ": " + speech);
	}
}
