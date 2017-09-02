package com.interviewquestions_nokia;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class CustomHashMap1<K,V> {

	public static void main(String[] args) {
		/*MyHashMap m=new MyHashMap();
		System.out.println(m.put("hh", "ss"));
		System.out.println(m.put("hh", "ssss"));
		*/
		System.out.println(199999 >>> 16);
		//m = (HashMap) Collections.synchronizedMap(m);
		//LinkedList n=new LinkedList<>();
		System.out.println(5&5);
		System.out.println(99999%10);
		
		//011 101
		System.out.println(3^5);
		int d=1;
		d|=10;
		
		//11=1011
		System.out.println(d>>1);
		
		String[] s=new String[10];
		System.out.println(s.length);
		
		HashMap m=new HashMap<>(20);
		m.put("1", "11");
		System.out.println(m.size());
	}

	
	
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
	

}
