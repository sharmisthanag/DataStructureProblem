package com.java8.test.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.swing.plaf.synth.SynthScrollBarUI;


public class SortPersonUsingJava8BuiltInFunctions {

	public static void main(String[] args) {
		
		List<Person> list= Arrays.asList(
				new Person("cccc","aaaa",27),
				new Person("dddd","asdg",27),
				new Person("eeee","jhtg",27)
				);
		System.out.println(list);
		//sort people based on lastName
		Collections.sort(list,(p,q) -> p.getLastName().compareTo(q.getLastName()));
		
		//print people after sort
		System.out.println("Print people in list");
		printConditionally(list,p -> true,p->System.out.println(p));
		
		//print people whose first name begins with "c"
		System.out.println("print people whose first name begins with \"c\"");
		printConditionally(list,p -> p.getFirstName().startsWith("c"),p->System.out.println(p.getFirstName()));
		
		
		//print people whose last name begins with "a"
		System.out.println("print people whose last name begins with \"a\"");
		printConditionally(list,p-> p.getLastName().startsWith("a"),p->System.out.println(p.getLastName()));
		

	}

	private static void printConditionally(List<Person> list, Predicate<Person> predicate,Consumer<Person> consumer) {
		for(Person p:list){
			if(predicate.test(p)){
				consumer.accept(p);
			}
		}
		
	}
}
