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
		boolean result = ssi.requirementCheck();
		boolean expected = (true);
		assertEquals(expected, result);
	}
	
	@Test
	void CheckAOCDetailsTwoCapitalLettersAndEightDigits() throws ExceptionMsg {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String input = "A3Jun401M";
		String result = ssi.initialiseAOCDetails(input);
		String expected = ("SSun27TL, Star, Sun, 83950000000, 695510, 2.5544e+17, 1.989 � 10^30");
		assertEquals(expected, result);
	}
	
	@Test
	void CheckAOCDetailsAdvanced() throws ExceptionMsg {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String input = "A99942Apo138M";
		String result = ssi.initialiseAOCDetails(input);
		String expected = ("SSun27TL, Star, Sun, 83950000000, 695510, 2.5544e+17, 1.989 � 10^30");
		assertEquals(expected, result);
	}
	
	
	@Test
	void AOCExceptionCheck() throws ExceptionMsg {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String input = "A99942ASFSAFEpo138M";
		String expected = ("No such astronomical object classification code");
		
		Exception exception = assertThrows(ExceptionMsg.class, ()-> {
			ssi.initialiseAOCDetails(input);
		});
		
		String result = exception.getMessage();
		
		assertTrue(result.contains(expected));
	}

	@Test
	void firstCodeDetails() {

		SolarSystemInformation ssi = new SolarSystemInformation(user, pword);
		String result = ssi.firstDetails("A99942Apo138M");
		assertEquals("Asteroid", result);
	}
	
	@Test
	void authenticate() {

		WebService ws = new WebService();
		boolean result = ws.authenticate(user, pword);
		assertEquals(true, result);
	}
	
	@Test
	void authenticatefail() {

		SolarSystemInformation ssi = new SolarSystemInformation("username", "123");
		boolean result = ssi.requirementCheck();
		assertEquals(false, result);
	}



}
