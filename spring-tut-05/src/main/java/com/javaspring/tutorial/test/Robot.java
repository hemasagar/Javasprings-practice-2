package com.javaspring.tutorial.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	private String id= "0";
	private String speech = "hello";
	
	@Autowired
	public void setId(@Value("root")String id) {
		this.id = id;
	}
	
	@Autowired
	public void setSpeech(@Value("abcd1234")String speech) {
		this.speech = speech;
	}
	
	public void speak() {
		System.out.println(id + ": " + speech);
	}
}
