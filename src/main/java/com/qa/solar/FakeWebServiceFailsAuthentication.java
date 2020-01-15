package com.qa.solar;

public class FakeWebServiceFailsAuthentication implements IAstroService{

	public boolean authenticate (String userID, String password) {
		return false;
		
	}
	
	public String getStatusInfo (String astronomicalObjectClassificationCode) {
		return "Should not be called";
		//return "SSun27TL, Star, Sun, 83950000000, 695510, 2.5544e+17, 1.989 × 10^30";
	}
	
	
}
