package com.java8.test.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class SortPersonUsingJava8 {

	public static void main(String[] args) {
		
		List<Person> list= Arrays.asList(
				new Person("cccc","aaaa",27),
				new Person("dddd","asdg",27),
				new Person("eeee","jhtg",28)
				);
		
		//sort people based on lastName
		Collections.sort(list,(p,q) -> p.getLastName().compareTo(q.getLastName()));
		
		//print people after sort
		System.out.println("Print people in list");
		printConditionally(list,p -> true);
		
		//print people whose first name begins with "c"
		System.out.println("print people whose first name begins with \"c\"");
		printConditionally(list,p -> p.getFirstName().startsWith("c"));
		
		
		//print people whose last name begins with "a"
		System.out.println("print people whose last name begins with \"a\"");
		printConditionally(list,p-> p.getLastName().startsWith("a"));
		
		System.out.println("***");
		
		printConditionallyWithPredcate(list,p -> p.getAge()>27);

	}

	private static void printConditionallyWithPredcate(List<Person> l,Predicate<Person> p) {
		for(Person per:l){
		if(p.test(per)){
			System.out.println(per);
		}
		}
		
	}

	private static void printConditionally(List<Person> list, Conditions condition) {
		for(Person p:list){
			if(condition.test(p)){
				System.out.println(p);
			}
		}
		
	}
}
