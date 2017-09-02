package com.interviewquestions;

import java.util.ArrayList;

public class ArrayListAndVector {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		a.add(1);

		int i=10;
		i = i+ (i>>1);
		System.out.println(i);
	}

}

interface MyMap<K, V>{
void put(K key, V value);
<V> void get(K key);
}