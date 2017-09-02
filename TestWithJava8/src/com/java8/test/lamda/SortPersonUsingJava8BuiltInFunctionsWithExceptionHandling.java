package com.java8.test.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.swing.plaf.synth.SynthScrollBarUI;


public class SortPersonUsingJava8BuiltInFunctionsWithExceptionHandling  {

	public static void main(String[] args) {
		
		Integer[] ai={1,2,4,5,7,8,9};
		
		//sort people based on lastName
		Collections.sort(Arrays.asList(ai),(p,q)->q.compareTo(p));
		
		//print people after sort
		System.out.println("Print add in list");
		doArithmeticOperation(Arrays.asList(ai),2,wrapper((p,q) -> System.out.println(p+q)));
		
		//print people whose first name begins with "c"
		System.out.println("print multiply");
		doArithmeticOperation(Arrays.asList(ai),2,wrapper((p,q) -> System.out.println(p*q)));
		
		
		//print people whose last name begins with "a"
		System.out.println("print division");
		doArithmeticOperation(Arrays.asList(ai),0,wrapper((p,q) -> System.out.println(p/q)));

	}

	private static BiConsumer<Integer, Integer> wrapper(BiConsumer<Integer, Integer> biConsumer) {
		return (r,v) -> {
			try{
				biConsumer.accept(r, v);
			}
			catch(Exception e){
				System.out.println("caught exception in "+e.getClass());
			}
			
		};
		
	}

	private static void doArithmeticOperation(List<Integer> p,Integer key,BiConsumer<Integer, Integer> biConsumer) {
		for(int i:p){
			biConsumer.accept(i, key);
		}
		
	}
}
