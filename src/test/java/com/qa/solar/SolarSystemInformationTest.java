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
	
	@Test
	void CheckAOCDetailsTwoCapitalLettersAndEightDigits() {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String input = "A3Jun401M";
		String result = ssi.initialiseAOCDetails(input);
		String expected = ("Requirement check for AOC passed");
		assertEquals(expected, result);
	}
	
	@Test
	void CheckAOCDetailsAdvanced() {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String input = "A99942Apo138M";
		String result = ssi.initialiseAOCDetails(input);
		String expected = ("Requirement check for AOC passed");
		assertEquals(expected, result);
	}

	
	


}
