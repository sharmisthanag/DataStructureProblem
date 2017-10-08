package ImplementComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableImplementaion {

	public static void main(String[] args) {
		List<Employee> l=new ArrayList<Employee>();
		l.add(new Employee(2));
		l.add(new Employee(3));
		l.add(new Employee(1));
		l.add(new Employee(9));
		Collections.sort(l);
		System.out.println(l);
		
		//------------
		List<Employee> l1=new ArrayList<Employee>();
		l1.add(new Employee(2,"A"));
		l1.add(new Employee(3,"B"));
		l1.add(new Employee(1,"C"));
		l1.add(new Employee(9,"0D"));
		Collections.sort(l1, new SortEmployeeBasedOnName());
		System.out.println(l1);
		//l1.forEach();
		
	}

}
class Employee implements Comparable<Employee> {
	

	private int empId;
	private String name;
	Employee(int empId){
		this.empId = empId;
	}
	Employee(int empId,String name){
		this.empId = empId;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@Override
	public int compareTo(Employee o) {
		if(this.empId==o.getEmpId()){
			return 0;
		}
		else{
			return this.getEmpId()-o.empId;
		}
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
}

class SortEmployeeBasedOnName  implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return -(o1.getName().compareTo(o2.getName()));
	}
	
}
 