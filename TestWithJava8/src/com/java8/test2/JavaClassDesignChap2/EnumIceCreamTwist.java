package com.java8.test2.JavaClassDesignChap2;

public enum EnumIceCreamTwist {
	VANILLA("white"),
	STRAWBERRY("pink"),
	WALNUT("brown"),
	CHOCOLATE("dark brown");
	String color;
	EnumIceCreamTwist(String color) {
		this.color = color;
	}
	public static void main(String[] args) {
		System.out.println(VANILLA); //line1
		System.out.println(CHOCOLATE); //line2
	}
}
class CanClassExtendEnum implements EnumIceCreamTwist{
	public static void main(String[] args) {
		
	}
}