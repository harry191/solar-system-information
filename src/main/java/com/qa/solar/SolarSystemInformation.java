package com.qa.solar;

public class SolarSystemInformation {

	private String userID;
	private String password;
	private Boolean length;
	

	public SolarSystemInformation(String userID, String password) {
		if (userID.length() == 6) {
			length = true;
		}else {
			length = false;
		}
		
	}
	
	public String lengthCheck(){
		if (length == true) {
			return ("Length check passed");
		}else {
			return ("Length check failed");
		}
	}
	
}
