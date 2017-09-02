package com.collectionframeowrkpracticess;

import java.util.ArrayList;
import java.util.List;

public class SUblistCheck {

	public static void main(String[] args) {
		 List<String> l=new ArrayList<>();
	        l.add("a");l.add("b");l.add("c");l.add("d");l.add("e");l.add("f");l.add("g");
	        List sub = l.subList(0, 2);
	        
	       sub.add("*");
	       sub.add(1, "1");
	       l.add("*");
	       
	       l.add(0, "&");
	       sub.get(0);
	       System.out.println(l);
	       System.out.println(sub);
	       //when sublist add any data,it copies the parent modcount to itself,but when list changes it simply increment the modcount of itself.now sublist modcount is not equal to actual arraylist modcount value ,so checkmodificationmethod throws concurrent exception
	       
	       System.out.println(l);
	       System.out.println(sub);
	       
	       
	}

}
