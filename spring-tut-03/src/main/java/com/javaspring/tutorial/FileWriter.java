package com.javaspring.tutorial;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Qualifier("filewriter")
@Component("fileWriter")
public class FileWriter implements LogWriter {

	public void write(String text) {
		System.out.println("Filewriter: "+text);	
	}
	
}
