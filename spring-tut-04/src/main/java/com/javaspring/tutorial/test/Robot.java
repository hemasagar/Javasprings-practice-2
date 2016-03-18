package com.javaspring.tutorial.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	private String id= "123";
	private String speech = "hello";
	
	@Autowired
	// randomText.getText()?.length()
	// T(Math).round(T(Math).random()*10)
	public void setId(@Value("#{randomText.getText()?.length()}")String id) {
		this.id = id;
	}

	@Autowired
	// randomText.getText()
	// new java.util.Date().toString()
	// T(Math).sin(T(Math).PI/4) ^ 2 lt 0.8
	public void setSpeech(@Value("#{T(Math).sin(T(Math).PI/4) ^ 2 lt 0.8 ? 'yes':'no'}")String speech) {
		this.speech = speech;
	}
	
	public void speak() {
		System.out.println(id + ": " + speech);
	}
}
