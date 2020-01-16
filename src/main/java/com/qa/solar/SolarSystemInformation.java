package com.qa.solar;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

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

	IAstroService as = null;
	public SolarSystemInformation(String userID, String password, IAstroService as) {
		this.as = as;
		if (userID.matches("[A-Z]{2}[0-9]{4}") && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^+=!*()@%&]).{10,}$")) {
			pattern = true;
			this.as.authenticate(userID, password);
			requirementCheck();
		}else {
			pattern = false;
			setObjectName("Not allowed");
			setObjectType("Not allowed");
			setExists(false);
			setOrbitalPeriod(null);
			setRadius(null);
			setSemiMajorAxis(null);
			setMass(null);
			setAstronomicalObjectClassificationCode("Not allowed");
			
			
		}


	}
	
	public boolean requirementCheck(){
		if (pattern == true) {
			return as.authenticate(userID, password);
		}else {
			return false;
		}
	}
	
	public void initialiseAOCDetails(String astronomicalObjectClassificationCode) throws ExceptionMsg {
		if (pattern == true) {
			
			if (astronomicalObjectClassificationCode.matches("\\A[A-Z]{2}[a-z]{2}[0-9]{1,8}[A-Z]{1,2}")||astronomicalObjectClassificationCode.matches("\\A[A-Z]{1}[0-9]{1,5}[A-Z]{1}[a-z]{2}[0-9]{3}[A-Z]{1}")) {
				String info =  as.getStatusInfo(astronomicalObjectClassificationCode);
				String[] array = info.split(",");
				MathContext mc = new MathContext(3);
				try {
					BigDecimal bd = new BigDecimal(array[4]);
					BigDecimal bdSMA = new BigDecimal(array[5]);
					BigDecimal bdM = new BigDecimal(array[6],mc);
					BigDecimal bdOP = new BigDecimal(array[3]);
					BigDecimal bdR = new BigDecimal(array[4],mc);
					setObjectName(array[2]);
					setObjectType(array[1]);
					setExists(true);
					setOrbitalPeriod(bdOP);
					setRadius(bd);
					setSemiMajorAxis(bdSMA);
					setMass(bdM);
					setAstronomicalObjectClassificationCode(astronomicalObjectClassificationCode);
				}catch(ArrayIndexOutOfBoundsException e) {
					throw new ExceptionMsg("String of infomation is missing parts");
				}catch(NumberFormatException e) {
					throw new ExceptionMsg("A number is not in integer form");
				}
				
			}else {
					throw new ExceptionMsg("No such astronomical object classification code");
				}
				
			}
			else {
			System.out.println("Not authenticated");
		}

		
	}
	
	public String toString() {

		return (getObjectType()+", "+getObjectName()+" ["+getAstronomicalObjectClassificationCode()+"] "+getRadius().toString()+"km, "+getMass().toString()+" kg");
		
	}
	
	public String getObjectType() {
		return objectType;
	}

	public String getObjectName() {
		return objectName;
	}

	public Boolean getExists() {
		return exists;
	}

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
	
	public String getAstronomicalObjectClassificationCode() {
		return astronomicalObjectClassificationCode;
	}

	private void setAstronomicalObjectClassificationCode(String astronomicalObjectClassificationCode) {
		this.astronomicalObjectClassificationCode = astronomicalObjectClassificationCode;
	}
	
}
