package com.qa.solar;

public class SolarSystemInformation {

	private String userID;
	private String password;
	private Boolean pattern;
	

	public SolarSystemInformation(String userID, String password) {
		if (userID.matches("[A-Z]{2}[0-9]{4}")) {
			pattern = true;
		}else {
			pattern = false;
		}if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^+=!*()@%&]).{8}") && password.length()==8) {
			pattern = true;
		}else {
			pattern = false;
		}

		
		
	}
	
	public String requirementCheck(){
		if (pattern == true) {
			return ("Requirement check for userID&password passed");
		}else {
			return ("Requirement check for userID&password failed");
		}
	}
	
}
