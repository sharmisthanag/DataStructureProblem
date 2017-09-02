package com.java8.test.javapiandarrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AddingElementsinArray {

	public static void main(String[] args) {
		List<String> l=new ArrayList<>();
		l.add("abc");
		l.add("gk");
		l.add("mmm");
		System.out.println(l);
		l.add(2, "jjj");
		System.out.println(l);
		
		
		//Removing value from ArrayList
		List<Integer> ll=new ArrayList<>();
		ll.add(1);ll.add(2);ll.add(3);ll.add(4);ll.add(5);
		System.out.println(ll);
		/*Iterator i=ll.iterator();
		while(i.hasNext()){//throws java.lang.IllegalStateException
			i.remove();
			System.out.println(i.next());
		}*/
		
		Integer removeElem = 4;
		Iterator<Integer> itr = ll.iterator();
        while(itr.hasNext()){	
        	Integer i=itr.next();
        	if(removeElem.equals(i))
        	{
        		itr.remove();
        		
        	}
		}
        
        //
        List<String> l2=new ArrayList<>();
		l2.add("1");l2.add("2");l2.add("3");l2.add("4");l2.add("5");     
		l2.remove("5");//no issue,but while in loop removing causes ConcurrentMOdificationException
        for(String i:l2){
        	if("4".equals(i)){
        		l2.remove("4");//throws ConcurrentMOdificationException
        	}
        }
		System.out.println(l2);
		
		//
		/*List<String> l21=new ArrayList<>();
		l21.add("1");l21.add("2");l21.add("3");l21.add("4");l21.add("5");  
		List<String> l211=new CopyOnWriteArrayList<>(l21);
		l211.removeIf( e->"5".equals(e));
		System.out.println(l211);*/
	}
}
