package com.qa.solar;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolarSystemInformationTest {

	@Test
	void CheckUserIDLength() {
		
		String input = ("XX3243");
		
		SolarSystemInformation ssi = new SolarSystemInformation(input, input);
		
		String result = ssi.lengthCheck();
		String expected = ("Length check passed");
		assertEquals(expected, result);
	}

}
