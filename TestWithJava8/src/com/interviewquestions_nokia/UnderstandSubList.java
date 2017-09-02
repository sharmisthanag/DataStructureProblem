package com.interviewquestions_nokia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnderstandSubList {

	public static void main(String[] args) {

		ArrayList l=new ArrayList();
		l.add("a");l.add("b");l.add("c");l.add("d");
		
		List b= l.subList(0, 2);
		
		System.out.println(l);
		System.out.println(b);
		l.add(1, "z");
		System.out.println(l);
		System.out.println(b.toString());
		
		
		Iterator i=l.iterator();
		while(i.hasNext()){
			//System.out.println(i.next());
			//i.next();
			i.remove();
			//System.out.println(i.next());
		}
		System.out.println(l);

	}

}
