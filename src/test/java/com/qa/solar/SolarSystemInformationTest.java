package com.qa.solar;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.EasyMock.*;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.Assert;
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
	void CheckAOCObjectOrbitalPeriod() throws ExceptionMsg {

		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		ssi.initialiseAOCDetails("SSun27TL");
		
		BigDecimal actual = ssi.getOrbitalPeriod();
		BigDecimal bd = new BigDecimal("83950000000");
		 
		assertEquals(bd, actual);
	}
	
	@Test
	void CheckAOCObjectExists() throws ExceptionMsg {

		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		ssi.initialiseAOCDetails("SSun27TL");
		
		Boolean actual = ssi.getExists();
		Boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	void CheckAOCObjectRadius() throws ExceptionMsg {

		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		ssi.initialiseAOCDetails("SSun27TL");
		
		BigDecimal actual = ssi.getRadius();
		BigDecimal bd = new BigDecimal("695510");
		
		assertEquals(bd, actual);
	}
	
	@Test
	void CheckAOCObjectSemiMajorAxis() throws ExceptionMsg {

		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		ssi.initialiseAOCDetails("SSun27TL");
		
		BigDecimal actual = ssi.getSemiMajorAxis();
		BigDecimal bd = new BigDecimal("255440000000000000");
		
		assertEquals(bd, actual);
	}
	
	@Test
	void CheckAOCObjectMass() throws ExceptionMsg {

		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		ssi.initialiseAOCDetails("SSun27TL");
		
		BigDecimal actual = ssi.getMass();
		BigDecimal bd = new BigDecimal("198900000000000000000000000000");
		
		assertEquals(bd, actual);
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
		assertEquals("Star, Sun [SSun27TL] 2.55E+17km, 1.99E+29 kg", result);
	}
	
	@Test
	void EasyMockStatusInfo() {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		IAstroService ws = new FakeWebServicePassesAuthentication();
		String actual = ws.getStatusInfo("SSun27TL");
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void EasyMockGetObjectName() throws ExceptionMsg {
		SolarSystemInformation ssi = EasyMock.createNiceMock(SolarSystemInformation.class);
		ssi.initialiseAOCDetails("SSun27TL");
		String expected = "Sun";
		EasyMock.expect(ssi.getObjectName()).andReturn(expected);
		EasyMock.replay(ssi);
		String actual = ssi.getObjectName();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void EasyMockGetObjectType() throws ExceptionMsg {
		SolarSystemInformation ssi = EasyMock.createNiceMock(SolarSystemInformation.class);
		ssi.initialiseAOCDetails("SSun27TL");
		String expected = "Star";
		EasyMock.expect(ssi.getObjectType()).andReturn(expected);
		EasyMock.replay(ssi);
		String actual = ssi.getObjectType();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void EasyMockGetObjectMass() throws ExceptionMsg {
		SolarSystemInformation ssi = EasyMock.createNiceMock(SolarSystemInformation.class);
		ssi.initialiseAOCDetails("SSun27TL");
		BigDecimal expected = new BigDecimal("198900000000000000000000000000");
		EasyMock.expect(ssi.getMass()).andReturn(expected);
		EasyMock.replay(ssi);
		BigDecimal actual = ssi.getMass();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void EasyMockGetObjectOrbitalPeriod() throws ExceptionMsg {
		SolarSystemInformation ssi = EasyMock.createNiceMock(SolarSystemInformation.class);
		ssi.initialiseAOCDetails("SSun27TL");
		BigDecimal expected = new BigDecimal("83950000000");
		EasyMock.expect(ssi.getOrbitalPeriod()).andReturn(expected);
		EasyMock.replay(ssi);
		BigDecimal actual = ssi.getOrbitalPeriod();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	void EasyMockGetObjectRadius() throws ExceptionMsg {
		SolarSystemInformation ssi = EasyMock.createNiceMock(SolarSystemInformation.class);
		ssi.initialiseAOCDetails("SSun27TL");
		BigDecimal expected = new BigDecimal("2");
		EasyMock.expect(ssi.getRadius()).andReturn(expected);
		EasyMock.replay(ssi);
		BigDecimal actual = ssi.getRadius();
		Assert.assertEquals(expected, actual);
	}



}
