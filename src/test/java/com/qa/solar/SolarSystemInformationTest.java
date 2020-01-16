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
	void CheckUserIDPasswordRequirementsPass() {

		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		boolean result = ssi.requirementCheck();
		boolean expected = (true);
		assertEquals(expected, result);
	}
	
	@Test
	void CheckUserIDPasswordRequirementsFail() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		boolean result = ssi.requirementCheck();
		boolean expected = (false);
		assertEquals(expected, result);
	}
	
	@Test
	void IDUserFailCheckObjectName() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", pword, ws);
		String result = ssi.getObjectName();
		String expected = ("Not allowed");
		assertEquals(expected, result);
	}
	
	@Test
	void IDPasswordFailCheckObjectName() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, "23", ws);
		String result = ssi.getObjectName();
		String expected = ("Not allowed");
		assertEquals(expected, result);
	}
	
	@Test
	void IDFailCheckObjectName() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", "23", ws);
		String result = ssi.getObjectName();
		String expected = ("Not allowed");
		assertEquals(expected, result);
	}
	
	@Test
	void IDUserFailCheckObjectType() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", pword, ws);
		String result = ssi.getObjectType();
		String expected = ("Not allowed");
		assertEquals(expected, result);
	}
	
	@Test
	void IDPasswordFailCheckObjectType() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, "23", ws);
		String result = ssi.getObjectType();
		String expected = ("Not allowed");
		assertEquals(expected, result);
	}
	
	@Test
	void IDFailCheckObjectType() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", "23", ws);
		String result = ssi.getObjectType();
		String expected = ("Not allowed");
		assertEquals(expected, result);
	}
	
	@Test
	void IDUserFailCheckObjectExists() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", pword, ws);
		boolean result = ssi.getExists();
		boolean expected = (false);
		assertEquals(expected, result);
	}
	
	@Test
	void IDPasswordFailCheckObjectExists() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, "23", ws);
		boolean result = ssi.getExists();
		boolean expected = (false);
		assertEquals(expected, result);
	}
	
	@Test
	void IDFailCheckObjectExists() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", "23", ws);
		boolean result = ssi.getExists();
		boolean expected = (false);
		assertEquals(expected, result);
	}
	
	@Test
	void IDUserFailCheckObjectOrbitalPeriod() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", pword, ws);
		BigDecimal result = ssi.getOrbitalPeriod();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDPasswordFailCheckObjectOrbitalPeriod() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, "23", ws);
		BigDecimal result = ssi.getOrbitalPeriod();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDFailCheckObjectOrbitalPeriod() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", "23", ws);
		BigDecimal result = ssi.getOrbitalPeriod();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDFailCheckRadius() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", "23", ws);
		BigDecimal result = ssi.getRadius();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDUserFailCheckRadius() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", pword, ws);
		BigDecimal result = ssi.getRadius();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDPasswordFailCheckRadius() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, "23", ws);
		BigDecimal result = ssi.getRadius();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDUserFailCheckSemiMajorAxis() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", pword, ws);
		BigDecimal result = ssi.getSemiMajorAxis();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDPasswordFailCheckSemiMajorAxis() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, "23", ws);
		BigDecimal result = ssi.getSemiMajorAxis();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDFailCheckSemiMajorAxis() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", "23", ws);
		BigDecimal result = ssi.getSemiMajorAxis();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDFailCheckMass() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", "23", ws);
		BigDecimal result = ssi.getMass();
		BigDecimal expected = (null);
		assertEquals(expected, result);
	}
	
	@Test
	void IDFailCheckAstronomicalObjectClassificationCode() {

		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("23", "23", ws);
		String result = ssi.getAstronomicalObjectClassificationCode();
		String expected = ("Not allowed");
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
		BigDecimal bd = new BigDecimal("1.99E+29");
		
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
	void InvalidUsernameAndPassword() {
		IAstroService ws = new FakeWebServiceFailsAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation("username", "123", ws);
		boolean result = ssi.requirementCheck();
		assertEquals(false, result);
	}
	
	@Test
	void SeeIfPlanetInfoIsCorrectFormat() throws ExceptionMsg {
		IAstroService ws = new FakeWebServicePassesAuthentication();
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ws);
		ssi.initialiseAOCDetails("SSun27TL");
		String result = ssi.toString();
		assertEquals("Star, Sun [SSun27TL] 695510km, 1.99E+29 kg", result);
	}
	
	@Test
	void EasyMockStatusInfo() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		String result = ssi.getObjectName();
		Assert.assertEquals("Sun", result);
	}
	
	@Test
	void EasyMockToString() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		String result = ssi.toString();
		Assert.assertEquals("Star, Sun [SSun27TL] 695510km, 1.99E+29 kg", result);
	}
	
	@Test
	void EasyMockToStringSecondTest() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "Code,Type,Name,83950000000,3,3,5";

		EasyMock.expect(ias.authenticate(user, pword)).andReturn(true);
		EasyMock.expect(ias.getStatusInfo("A99942Apo138M")).andReturn(expected);
		EasyMock.replay(ias);
		
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("A99942Apo138M");
		
		
		String result = ssi.toString();
		
		Assert.assertEquals("Type, Name [A99942Apo138M] 3km, 5 kg", result);
	}
	
	@Test
	void EasyMockAOCName() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		String result = ssi.getObjectName();
		Assert.assertEquals("Sun", result);
	}
	
	@Test
	void EasyMockAOCType() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		String result = ssi.getObjectType();
		Assert.assertEquals("Star", result);
	}
	
	@Test
	void EasyMockAOCMass() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		BigDecimal result = ssi.getMass();
		BigDecimal bd = new BigDecimal("1.99E+29");
		Assert.assertEquals(bd, result);
	}
	
	@Test
	void EasyMockAOCRadius() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		BigDecimal result = ssi.getRadius();
		BigDecimal bd = new BigDecimal("695510");
		Assert.assertEquals(bd, result);
	}
	
	@Test
	void EasyMockAOCSMA() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		BigDecimal result = ssi.getSemiMajorAxis();
		BigDecimal bd = new BigDecimal("255440000000000000");
		Assert.assertEquals(bd, result);
	}
	
	@Test
	void EasyMockAOCOrbitTime() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		BigDecimal result = ssi.getOrbitalPeriod();
		BigDecimal bd = new BigDecimal("83950000000");
		Assert.assertEquals(bd, result);
	}
	
	@Test
	void EasyMockAOCExists() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "SSun27TL,Star,Sun,83950000000,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		ssi.initialiseAOCDetails("SSun27TL");
		Boolean result = ssi.getExists();
		Assert.assertEquals(true, result);
	}
	
	@Test
	void EasyMockToStringMissingDataInArray() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "test,ds,ds,695510,255440000000000000,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		String expectedother = ("String of infomation is missing parts");
		Exception exception = assertThrows(ExceptionMsg.class, ()-> {
			ssi.initialiseAOCDetails("SSun27TL");
		});
		String result = exception.getMessage();
		assertTrue(result.contains(expectedother));
		
	}
	
	
	@Test
	void EasyMockToStringDataNotInCorrectDataType() throws ExceptionMsg {
		IAstroService ias = EasyMock.createNiceMock(IAstroService.class);
		String expected = "test,ds,ds,695510,twentytwo,198900000000000000000000000000";
		EasyMock.expect(ias.getStatusInfo("SSun27TL")).andReturn(expected);
		EasyMock.replay(ias);
		SolarSystemInformation ssi = new SolarSystemInformation(user, pword, ias);
		String expectedother = ("A number is not in integer form");
		Exception exception = assertThrows(ExceptionMsg.class, ()-> {
			ssi.initialiseAOCDetails("SSun27TL");
		});
		String result = exception.getMessage();
		assertTrue(result.contains(expectedother));
		
	}

	

	
	
	


}
