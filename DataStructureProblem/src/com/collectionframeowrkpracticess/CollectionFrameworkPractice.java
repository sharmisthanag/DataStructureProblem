package com.collectionframeowrkpracticess;

import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionFrameworkPractice {

	public static void main(String[] args) {
		List l =new ArrayList();
		l.add(1);l.add(2);l.add(3);
		l.forEach(System.out::println);
		
		List l1 =new LinkedList();
		l1.add(1);l1.add(2);l1.add(3);
		l1.forEach(System.out::println);
		
		HashMap hm=new HashMap();
		hm.put("k", "v");
		hm.put("jj","ff");
		hm.forEach((k,v)->System.out.println(k+","+v));

		Set s=new HashSet();
		s.add(1);s.addAll(l1);
		s.forEach(System.out::println);
		
		List l11=new CopyOnWriteArrayList();
		
		
		System.out.println("*********88");
		CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();
        threadSafeList.add("Java");
        threadSafeList.add("J2EE");
        threadSafeList.add("Collection");
        
        
     
        //add, remove operator is not supported by CopyOnWriteArrayList iterator
        Iterator<String> failSafeIterator = threadSafeList.iterator();
        while(failSafeIterator.hasNext()){
            System.out.printf("Read from CopyOnWriteArrayList : %s %n", failSafeIterator.next());
            failSafeIterator.remove(); //not supported in CopyOnWriteArrayList in Java
        }


		
	}

}
class gg extends AbstractList{

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class ggg extends AbstractMap{

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
class gggg extends AbstractSequentialList{

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class ggggg extends AbstractSet{

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
	
	
}