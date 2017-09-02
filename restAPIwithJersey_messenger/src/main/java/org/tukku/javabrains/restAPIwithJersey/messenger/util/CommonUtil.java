package org.tukku.javabrains.restAPIwithJersey.messenger.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.tukku.javabrains.restAPIwithJersey.messenger.beans.Employee;
import org.tukku.javabrains.restAPIwithJersey.messenger.databases.DummyDataBaseClass;

public class CommonUtil {

	public static void main(String[] args) {
		Calendar c= Calendar.getInstance();
		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(Calendar.getInstance());
		List<Employee> l=new ArrayList<Employee>();
		l.add(new Employee((long) 1,"aaa","ggg"));
		l.add(new Employee((long) 2,"aaa","ggg"));
		l.add(new Employee((long) 3,"aaa","ggg"));
		l.add(new Employee((long) 4,"aaa","ggg"));
		l.add(new Employee((long) 5,"aaa","ggg"));
		l.add(new Employee((long) 6,"aaa","ggg"));
		
		System.out.println(l.size());
		System.out.println(l.subList(2, 7));
		
		
	}

}
