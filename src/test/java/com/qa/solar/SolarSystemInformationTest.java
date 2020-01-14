package com.qa.solar;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolarSystemInformationTest {

	String user = ("XX3243");
	String pword = ("XXxx!!23Fds");
	
	@Test
	void CheckUserIDPasswordRequirements() {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String result = ssi.requirementCheck();
		String expected = ("Requirement check for userID&password passed");
		assertEquals(expected, result);
	}

	


}
