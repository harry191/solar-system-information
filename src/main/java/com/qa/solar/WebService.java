package com.qa.solar;

public class WebService implements IAstroService{

	public boolean authenticate (String userID, String password) {
		return true;
		
	}
	
	public String getStatusInfo (String astronomicalObjectClassificationCode) {
		return "SSun27TL, Star, Sun, 83950000000, 695510, 2.5544e+17, 1.989 � 10^30";
	}
	
	
}
