
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ComparatorWithEquals {

	public static void main(String[] args) {
		Set t=new TreeSet(new EmployeeComparator123());
		t.add(new Employee123(1,"A"));
		t.add(new Employee123(2,"B"));
		t.forEach(System.out::println);
		
		System.out.println("******************* Treemap");
		Map<Employee123, String> t1=new TreeMap(new EmployeeComparator123());
		t1.put(new Employee123(1,"A"), "dd");
		t1.put(new Employee123(2,"B"), "kk");
		t1.forEach((k,v)->System.out.println(k+"="+v));
		System.out.println("*******************HashMap");
		
		Map m=new HashMap();
		m.put(new Employee123(1,"A"), "A");
		m.put(new Employee123(1,"A"), "B");
		System.out.println(m);
		
		//Collections.sort(new ArrayList(m.keySet()),new EmployeeComparator());
		
		Map tm=new TreeMap(new EmployeeComparator123());
		tm.putAll(m);
		System.out.println(tm);
		System.out.println("*********HashSet");
		Set s=new HashSet();
		s.add(new Employee123(1,"A"));
		s.add(new Employee123(1,"A"));
	}

}
class Employee123 {
	private int i;
	private String name;
	
	Employee123(int i,String name){
		this.i = i;
		this.name = name;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj){
		System.out.println("in equals");
		return false;
	}
	public int hashCode(){
		System.out.println("in hashcode");
		return 10;
	}
	@Override
	public String toString() {
		return "Employee [i=" + i + ", name=" + name + "]";
	}
	
}
class EmployeeComparator123 implements Comparator<Employee123>{

	@Override
	public int compare(Employee123 o1, Employee123 o2) {
		System.out.println("in compare=");
		System.out.println(o1.getName().compareTo(o2.getName()));
		return o1.getName().compareTo(o2.getName());
	}
	
}