package com.java8.test.methodOverloading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class OverloadedPractice {
	static final int MAXIMUM_CAPACITY = 1 << 30;
	static final int MIN_SEGMENT_TABLE_CAPACITY = 2;

	public static void main(String[] args) {
		int sshift = 0;
		int ssize = 1;
		int concurrencyLevel=16;
		while (ssize < concurrencyLevel) {
			++sshift;
			System.out.println("sshift: "+sshift);
			ssize <<= 1;
			System.out.println("ssize: "+ssize);
		}

		int segmentShift = 32 - sshift;
		int segmentMask = ssize - 1;

		int initialCapacity=32;;
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		int c = initialCapacity / ssize;
		if (c * ssize < initialCapacity)
			++c;
		int cap = MIN_SEGMENT_TABLE_CAPACITY;
		while (cap < c)
			cap <<= 1;
		/*ConcurrentHashMap chm=new ConcurrentHashMap(10,(float) 0.1);
		ConcurrentHashMap chm1=new ConcurrentHashMap();
		chm1.put("ff", null);//nullpointerexception

		CopyOnWriteArrayList<String> c=new CopyOnWriteArrayList();
		c.add(null);*/
		//new ConcurrentPrac().test(null);//test 1 ,2 3
		//new ConcurrentPrac().test('a');//test 4
		
		/*System.out.println(null);//It gave compiler error because call to println(null) is ambiguous and compiler will not able 
        to decide as which method to invoke among multiple overloaded println() method as none
        of the class level parameter is more specific.*/

	}
	//1
	/*void test(StringBuffer a){

	}*/
	//2
	/*void test(String s){

	}
	void test(Object o){
		
	}*/
	//3
	/*public void test(Object obj) {
        System.out.println("Object");
    }
    public void test(char[] obj) {
        System.out.println("Char");
    } 
    public void test(Integer obj) {
        System.out.println("Int");
    } */
	//4
	/*public void test(char obj) {
        System.out.println("Char");
    }*/
    public void test(int obj) {
        System.out.println("Int");
    } 
}
