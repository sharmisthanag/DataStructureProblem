package com.interviewquestions;

import java.util.EnumMap;

public class EnumMapDemo {

	public static void main(String[] args) {
		EnumMap<Color, Object> em=new EnumMap<Color, Object>(Color.class);
		em.put(Color.BLUE, "Blue in Color");
		em.put(Color.GREEN, 23);
		em.put(Color.PINK, "I am Girl");
		em.put(Color.RED, null);
		System.out.println(em);

	}

}
enum Color{
	RED,BLUE,GREEN,PINK;
}