package com.java8.test2.JavaClassDesignChap2;
/*
The enum constant list must be the first in the enum definition
and should be followed by a semicolon. A semicolon is optional if
you don’t add methods and variables to your enum.*/

public enum EnmWithConstants {
	VANILLA, STRAWBERRY, WALNUT, CHOCOLATE;
	private String color;
	
	public String getColor() {
		return color;
	}
	public void setColor(String val) {
		color = val;
	}
}
