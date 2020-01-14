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
	void CheckAOCDetailsTwoCapitalLettersAndEightDigits() throws ExceptionMsg {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String input = "A3Jun401M";
		String result = ssi.initialiseAOCDetails(input);
		String expected = ("Requirement check for AOC passed");
		assertEquals(expected, result);
	}
	
	@Test
	void CheckAOCDetailsAdvanced() throws ExceptionMsg {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String input = "A99942Apo138M";
		String result = ssi.initialiseAOCDetails(input);
		String expected = ("Requirement check for AOC passed");
		assertEquals(expected, result);
	}
	
	
	@Test
	void AOCExceptionCheck() throws ExceptionMsg {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String input = "A99942ASFSAFEpo138M";
		String expected = ("Wrong format");
		
		Exception exception = assertThrows(ExceptionMsg.class, ()-> {
			ssi.initialiseAOCDetails(input);
		});
		
		String result = exception.getMessage();
		
		assertTrue(result.contains(expected));
	}

//	@Test
//	void ToStringMethod() {
//
//		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
//		String input = "PMer58M";
//		String result = ssi.toString(input);
//		String expected = ("Planet");
//		assertEquals(expected, result);
//	}
	
	


}
