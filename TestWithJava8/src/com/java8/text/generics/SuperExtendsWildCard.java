package com.java8.text.generics;

import java.util.ArrayList;
import java.util.List;

public class SuperExtendsWildCard {

	public static void main(String[] args) {
		List<? extends Number> foo = new ArrayList<>(19);
		List<Number> nl = new ArrayList<Number>();
		nl.add(2);
		foo = nl;
		System.out.println(foo.get(0));
		
		
		List<String> sl = new ArrayList<String>();
		List<Integer> il = new ArrayList<Integer>();
		sl.add("three");
		il.add(3);
		print(sl);
		print(il);
		

	}
	static <T> void print(List<T> l){
		for(Object ob : l){
			System.out.println(ob);
		}
	}

}
