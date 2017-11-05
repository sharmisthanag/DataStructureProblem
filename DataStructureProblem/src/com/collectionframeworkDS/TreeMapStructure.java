package com.collectionframeworkDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TreeMapStructure {

	public static void main(String[] args) {
		
		ArrayList al=new ArrayList();
		al.add(10);
		LinkedList<Integer> ll=new LinkedList();
		ll.add(20);
		
		TreeMap<Mapkey,Integer> tm=new TreeMap<>();
		Mapkey k=new Mapkey(10, "shar", new Date());
		tm.put(k, 10);
		Mapkey k1=new Mapkey(10, "shar", new Date());
		tm.put(k1, 20);
		System.out.println(tm);
		System.out.println(tm.get(k));
		//Shouldn't .equals and .compareTo produce same result?
		System.out.println(tm.containsKey(k));
		HashMap<String,String> hm=new HashMap<>();		
		
		LinkedHashMap<String,String> lhm=new LinkedHashMap<>(10);	
		lhm.put("dd", "20");
		System.out.println(lhm.toString());
		//hm.containsKey(k1);
		for(Map.Entry<String,String> hh:hm.entrySet()) {
			
		}
		
		for(Map.Entry<Mapkey,Integer> m:tm.entrySet()) {
			
		}
		System.out.println("****CP***");
		CopyOnWriteArrayList<Integer> cp=new CopyOnWriteArrayList<>();
		cp.add(10);cp.add(20);cp.add(30);cp.add(40);cp.add(50);cp.add(60);
		cp.remove(1);cp.remove(1);
		Iterator i=cp.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
			System.out.println(i.next());
			cp.add(30);
		}
		i=cp.iterator();
		System.out.println(i.next());
		System.out.println(i.next());
		System.out.println(i.next());
		System.out.println(i.next());


		System.out.println(cp);
		
		ArrayList<Integer> al1=new ArrayList();
		al1.add(10);al1.add(20);al1.add(30);al1.add(40);al1.add(50);al1.add(60);al1.add(70);
		Iterator ali=al1.iterator();
		while(ali.hasNext()) {
			System.out.println(ali.next());
			System.out.println("2nd i.next="+ali.next());
			//al.add(30);
		}
		System.out.println(al1);
		
	}

}
class Mapkey implements Comparable<Mapkey>{
	private int data;
	private String name;
	private Date date;
	public Mapkey(int data,String name,Date date) {
		this.data = data;
		this.name = name;
		this.date = date;
	}
	public int getData() {
		return data;
	}
	public String getName() {
		return name;
	}
	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "Mapkey [data=" + data + ", name=" + name + ", date=" + date + "]";
	}
	@Override
	public int compareTo(Mapkey o) {
		System.out.println("in compare");
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("in equals");
		return false;
	}
	@Override
	public int hashCode() {
		super.hashCode();
		System.out.println("in hashcode");
		return new Random().nextInt();
	}
	
}