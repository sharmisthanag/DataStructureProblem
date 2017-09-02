package com.java8.test.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPersonUsingJava7 {

	public static void main(String[] args) {
		
		List<Person> list= Arrays.asList(
				new Person("cccc","aaaa",27),
				new Person("dddd","asdg",27),
				new Person("eeee","jhtg",27)
				);
		
		//sort people based on lastName
		Collections.sort(list,new Comparator<Person>(){
			@Override
			public int compare(Person arg0, Person arg1) {				
				return arg0.getLastName().compareTo(arg1.getLastName());
			}
			
		});
		
		//print people after sort
		System.out.println("Print people in list");
		printAll(list);
		
		//print people whose first name begins with "c"
		System.out.println("print people whose first name begins with \"c\"");
		printConditionally(list,new Conditions(){

			@Override
			public boolean test(Person p) {
				
				return p.getFirstName().startsWith("c");
			}
			
		});
		
		
		//print people whose last name begins with "a"
		System.out.println("print people whose last name begins with \"a\"");
		printConditionally(list,new Conditions(){

			@Override
			public boolean test(Person p) {
				
				return p.getLastName().startsWith("a");
			}
			
		});

	}

	private static void printConditionally(List<Person> list, Conditions condition) {
		for(Person p:list){
			if(condition.test(p)){
				System.out.println(p);
			}
		}
		
	}

	private static void printAll(List<Person> list) {
		for(Person p:list){
			System.out.println(p);
		}		
	}

}
