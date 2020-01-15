package com.qa.solar;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SolarSystemInformation {

	private String userID;
	private String password;
	private Boolean pattern;
	private String astronomicalObjectClassificationCode;
	private String objectType;
	private String objectName;
	private Boolean exists;
	private BigDecimal orbitalPeriod;
	private BigDecimal radius;
	private BigDecimal semiMajorAxis;
	private BigDecimal mass;
	
	IAstroService ws = new FakeWebServicePassesAuthentication();
	public SolarSystemInformation(String userID, String password, IAstroService as) {
		if (userID.matches("[A-Z]{2}[0-9]{4}") && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^+=!*()@%&]).{10,}$")) {
			pattern = true;
			requirementCheck();
		}else {
			pattern = false;
			setObjectName("Not allowed");
			setObjectType("Not allowed");
			
		}
		
		
	}
	
	public boolean requirementCheck(){
		if (pattern == true) {
			return ws.authenticate(userID, password);
		}else {
			return false;
		}
	}
	
	
	public void initialiseAOCDetails(String astronomicalObjectClassificationCode) throws ExceptionMsg {
		IAstroService ws = new FakeWebServicePassesAuthentication();
		String info =  ws.getStatusInfo(astronomicalObjectClassificationCode);
		String[] array = info.split(",");
		BigDecimal bd = new BigDecimal(array[4]);
		BigDecimal bdSMA = new BigDecimal(array[5]);
		BigDecimal bdM = new BigDecimal(array[6]);
		BigDecimal bdOP = new BigDecimal(array[3]);
		BigDecimal bdR = new BigDecimal(array[4]);
		
		if (astronomicalObjectClassificationCode.matches("\\A[A-Z]{2}[a-z]{2}[0-9]{1,8}[A-Z]{1,2}")) {
			setObjectName(array[2]);
			setObjectType(array[1]);
			setExists(true);
			setOrbitalPeriod(bdOP);
			setRadius(bd);
			setSemiMajorAxis(bdSMA);
			setMass(bdM);
			
		}else {
			if (astronomicalObjectClassificationCode.matches("\\A[A-Z]{1}[0-9]{1,5}[A-Z]{1}[a-z]{2}[0-9]{3}[A-Z]{1}")) {
				setObjectName(array[2]);
				setObjectType(array[1]);
				setExists(true);
				setOrbitalPeriod(bdOP);
				setRadius(bd);
				setSemiMajorAxis(bdSMA);
				setMass(bdM);
			
				
				System.out.println(getObjectName()+getObjectType());
			}else {
				throw new ExceptionMsg("No such astronomical object classification code");
			}
			
		}
		
	}
	
	public String firstDetails(String astronomicalObjectClassificationCode) {
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
		
	

	
	public String toString(String AOC) {
		IAstroService ws = new FakeWebServicePassesAuthentication();
		String details = ws.getStatusInfo(AOC);
		String[] array = details.split(",");
		
		return (array[1]+", "+array[2]+" ["+array[0]+"] "+array[5]+"km, "+array[6]+" kg");
		
	}
	
	
	
	
	
	
	


//	public Boolean getPattern() {
//		return pattern;
//	}
//
//	public String getAstronomicalObjectClassificationCode() {
//		return astronomicalObjectClassificationCode;
//	}
//
	public String getObjectType() {
		return objectType;
	}

	public String getObjectName() {
		return objectName;
	}

//	public Boolean getExists() {
//		return exists;
//	}
//
	public BigDecimal getOrbitalPeriod() {
		return orbitalPeriod;
	}
//
	public BigDecimal getRadius() {
		return radius;
	}

	public BigDecimal getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public BigDecimal getMass() {
		return mass;
	}
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

	private void setExists(Boolean exists) {
		this.exists = exists;
	}

	private void setOrbitalPeriod(BigDecimal bdOP) {
		this.orbitalPeriod = bdOP;
	}

	private void setRadius(BigDecimal radius) {
		this.radius = radius;
	}

	private void setSemiMajorAxis(BigDecimal semiMajorAxis) {
		this.semiMajorAxis = semiMajorAxis;
	}

	private void setMass(BigDecimal mass) {
		this.mass = mass;
	}


	
	
	
	
}
