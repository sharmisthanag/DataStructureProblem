package org.tukku.javabrains.restAPIwithJersey.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.tukku.javabrains.restAPIwithJersey.messenger.beans.Employee;
import org.tukku.javabrains.restAPIwithJersey.messenger.databases.DummyDataBaseClass;
import org.tukku.javabrains.restAPIwithJersey.messenger.exceptions.DataNotFoundException;

public class EmployeeServices {
	
	Map<Long, Employee> employees = DummyDataBaseClass.getEmployees();
	
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(employees.values());
	}
	
	public Employee getEmployeeWithId(Long empId) {
		Employee getEmp = employees.get(empId);
		if(getEmp==null){
			throw new DataNotFoundException("Data Not found for id="+empId);
		}
		return getEmp;
	}
	
	public Employee addEmployee(Employee emp) {
		emp.setEmpId((long) (employees.size()+1));
		employees.put(emp.getEmpId(),emp);
		return emp;
	}
	
	public Employee updateEmployee(Employee emp) {
		if(emp.getEmpId() == null){
			return null;
		}
		employees.put(emp.getEmpId(), emp);
		return emp;
	}
	
	public String deleteEmployee(Long empId) {
		if(employees.containsKey(empId)){
			employees.remove(empId);
			return "deleted";
		}
		return "id not available";
	}

	public List<Employee> getEmployeeByYear(Integer year) {
		List<Employee> employeesByYear=new ArrayList<Employee>();		
		Calendar c= Calendar.getInstance();
		for(Employee emp:employees.values()){
			c.setTime(emp.getJoiningDate());
			System.out.println(year.intValue()+"=="+c.get(Calendar.YEAR));
			if(year.intValue() == c.get(Calendar.YEAR)){
				employeesByYear.add(emp);
			}
		}
		return employeesByYear;
	}

	public List<Employee> getEmployeeByStartPOSAndSize(Integer start, Integer size) {
		if(employees!=null && employees.size()>0){
			List<Employee> l=new ArrayList<Employee>(employees.values());
			if((start+size)>employees.size())
			{
				System.out.println("array out of bound exception");
				return l.subList(start, employees.size());
				
			}
			else{
				return l.subList(start, start+size);
			}
		}
		return null;
	}

}
