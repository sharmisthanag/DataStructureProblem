package com.interviewquestions_nokia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckListRemoveWithIteratorTwice {

	public static void main(String[] args) {
		List l=new ArrayList();
		l.add("a");l.add("b");l.add("c");l.add("d");
		l.get(4);
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
