package com.qa.solar;

public class ExceptionMsg extends Exception{

private String message;
	
	public ExceptionMsg(String msg) {
		message = msg;
	}
	
	public String getMessage() {
		return message;
	}
	
}
