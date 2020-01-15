package com.qa.solar;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class SolarSystemInformationTest {

	String user = ("XX3243");
	String pword = ("XXxx!!23Fds");
	
	@Test
	void CheckUserIDPasswordRequirements() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		boolean result = ssi.requirementCheck();
		boolean expected = (true);
		assertEquals(expected, result);
	}
	
	@Test
	void CheckAOCObjectType() throws ExceptionMsg {

		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		ssi.initialiseAOCDetails("SSun27TL");
		String result = ssi.getObjectType();
		String expected = "Star";
		assertEquals(expected, result);
	}
	
	@Test
	void CheckAOCObjectName() throws ExceptionMsg {

		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		ssi.initialiseAOCDetails("SSun27TL");
		
		String actual = ssi.getObjectName();
		String expected = "Sun";
		assertEquals(expected, actual);
	}
	
	
	@Test
	void AOCExceptionCheck() throws ExceptionMsg {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
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

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		String result = ssi.firstDetails("A99942Apo138M");
		assertEquals("Asteroid", result);
	}
	
	@Test
	void InvalidUsernameAndPassword() {
		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("username", "123", ws);
		boolean result = ssi.requirementCheck();
		assertEquals(false, result);
	}
	
	@Test
	void SeeIfPlanetInfoIsCorrectFormat() {
		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		String result = ssi.toString("SSun27TL");
		assertEquals("Star, Sun [SSun27TL] 255440000000000000km, 198900000000000000000000000000 kg", result);
	}



}
