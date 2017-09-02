package org.tukku.javabrains.restAPIwithJersey.messenger.databases;

import java.util.HashMap;
import java.util.Map;

import org.tukku.javabrains.restAPIwithJersey.messenger.beans.Employee;

public class DummyDataBaseClass {
	
	private static Map<Long,Employee> employees = new HashMap<>();

	public static Map<Long, Employee> getEmployees() {
		return employees;
	}

}
