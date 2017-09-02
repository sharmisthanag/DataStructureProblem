package com.defaultStaticMethodInInterface;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest {

	public static void main(String[] args) {
		Set s=new HashSet();
		s.add("1");
		s.add(null);
		s.add(null);
		System.out.println(s);
		
		
		List l=new ArrayList();
		l.add(1);l.add(2);l.add(null);l.add(null);
		System.out.println(l);
		
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("Java");
		hashSet.add(null);
		System.out.println(hashSet); 
		    
		System.out.println(hashSet.hashCode());
		
		Object s1=new Object();
		System.out.println(s1.hashCode());
		System.out.println(s1.toString());
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("C++");
		treeSet.add(null);


		

	}

}
