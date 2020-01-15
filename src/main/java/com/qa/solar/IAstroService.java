package com.qa.solar;

public interface IAstroService {
	boolean authenticate(String userID, String password);
	String getStatusInfo ( String astronomicalObjectClassificationCode);
}
