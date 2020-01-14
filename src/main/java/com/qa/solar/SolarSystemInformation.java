package com.qa.solar;

import java.math.BigDecimal;

public class SolarSystemInformation {

	private String userID;
	private String password;
	private Boolean pattern;
	private String astronomicalObjectClassificationCode;
	private String objectType;
	private String objectName;
	private Boolean exists;
	private int orbitalPeriod;
	private BigDecimal radius;
	private BigDecimal semiMajorAxis;
	private BigDecimal mass;
	

	public SolarSystemInformation(String userID, String password) {
		System.out.println(password.length());
		if (userID.matches("[A-Z]{2}[0-9]{4}") && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^+=!*()@%&]).{10,}$")) {
			pattern = true;
		}else {
			pattern = false;
			setObjectName("Not allowed");
			setObjectType("Not allowed");
		}
	}
	
	public String requirementCheck(){
		if (pattern == true) {
			return ("Requirement check for userID&password passed");
		}else {
			return ("Requirement check for userID&password failed");
		}
	}
	
	
	public String initialiseAOCDetails(String astronomicalObjectClassificationCode) throws ExceptionMsg {
		if (astronomicalObjectClassificationCode.matches("\\A[A-Z]{2}[a-z]{2}[0-9]{1,8}[A-Z]{1,2}")) {			
			return "Requirement check for AOC passed";
		}else {
			if (astronomicalObjectClassificationCode.matches("\\A[A-Z]{1}[0-9]{1,5}[A-Z]{1}[a-z]{2}[0-9]{3}[A-Z]{1}")) {
				return "Requirement check for AOC passed";
			}else {
				throw new ExceptionMsg("Wrong format");
			}
			
		}
		
	}
	
	public String codeDetails(String astronomicalObjectClassificationCode) {
		String firstChar = astronomicalObjectClassificationCode.substring(0, 1);
		if (firstChar.equals("S")) {
			System.out.println("Star");
			return "Star";
		}else if (firstChar.equals("P")) {
			System.out.println("Planet");
			return "Planet";
		}else if (firstChar.equals("M")) {
			System.out.println("Moon");
			return "Moon";
		}else if (firstChar.equals("D")) {
			System.out.println("Dwarf Planet");
			return "Dwarf Planet";
		}else if (firstChar.equals("A")) {
			System.out.println("Asteroid");
			return "Asteroid";
		}else{
			System.out.println("Comet");
			return "Comet";
		}
	}
	
	//public String toString(String AOC) {
		//String stringAOC = null;	
	//}
	
	
	
	
	
	
	


//	public Boolean getPattern() {
//		return pattern;
//	}
//
//	public String getAstronomicalObjectClassificationCode() {
//		return astronomicalObjectClassificationCode;
//	}
//
//	public String getObjectType() {
//		return objectType;
//	}

	public String getObjectName() {
		return objectName;
	}

//	public Boolean getExists() {
//		return exists;
//	}
//
//	public int getOrbitalPeriod() {
//		return orbitalPeriod;
//	}
//
//	public BigDecimal getRadius() {
//		return radius;
//	}
//
//	public BigDecimal getSemiMajorAxis() {
//		return semiMajorAxis;
//	}
//
//	public BigDecimal getMass() {
//		return mass;
//	}
//
//	private void setPattern(Boolean pattern) {
//		this.pattern = pattern;
//	}

//	private void setAstronomicalObjectClassificationCode(String astronomicalObjectClassificationCode) {
//		this.astronomicalObjectClassificationCode = astronomicalObjectClassificationCode;
//	}
//
	private void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	private void setObjectName(String objectName) {
		this.objectName = objectName;
	}
//
//	private void setExists(Boolean exists) {
//		this.exists = exists;
//	}
//
//	private void setOrbitalPeriod(int orbitalPeriod) {
//		this.orbitalPeriod = orbitalPeriod;
//	}
//
//	private void setRadius(BigDecimal radius) {
//		this.radius = radius;
//	}
//
//	private void setSemiMajorAxis(BigDecimal semiMajorAxis) {
//		this.semiMajorAxis = semiMajorAxis;
//	}
//
//	private void setMass(BigDecimal mass) {
//		this.mass = mass;
//	}


	
	
	
	
}
