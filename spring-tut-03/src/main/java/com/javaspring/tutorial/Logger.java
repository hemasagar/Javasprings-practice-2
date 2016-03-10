package com.javaspring.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Component
public class Logger {

//	@Autowired
	private ConsoleWriter consoleWriter;

/*	@Autowired
	private FileWriter fileWriter;*/
	
//	@Autowired
	private LogWriter fileWriter;
	
/*	@Autowired
	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}*/

//	@Autowired(required=false)
	
/*	@Autowired
	@Qualifier("toconsole")*/
	
//	@Resource
	@Inject
//	@Named(value="consolewriter")
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

/*	@Autowired
	@Qualifier("filewriter")*/
	
//	@Resource(name="test1")
	@Inject
	@Named(value="fileWriter")
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		if(consoleWriter != null)
			consoleWriter.write(text);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Ininitialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroyed");
	}

}
