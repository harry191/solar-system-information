package com.qa.solar;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolarSystemInformationTest {

	@Test
	void CheckUserIDRequirements() {
		
		String input = ("XX3243");
		SolarSystemInformation ssi = new SolarSystemInformation(input, input);
		String result = ssi.requirementCheck();
		String expected = ("Requirement check for userID passed");
		assertEquals(expected, result);
	}
	


}
