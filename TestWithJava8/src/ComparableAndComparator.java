import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ComparableAndComparator {

	public static void main(String[] args) {
		Set t=new TreeSet(new EmployeeComparator());
		t.add(new Employee(1,"A"));
		t.add(new Employee(2,"B"));
		t.forEach(System.out::println);
		
		System.out.println("*******************");
		Map<Employee, String> t1=new TreeMap(new EmployeeComparator());
		t1.put(new Employee(1,"B"), "dd");
		t1.put(new Employee(2,"A"), "kk");
		t1.forEach((k,v)->System.out.println(k+"="+v));
		System.out.println("*******************");
		
		Set t11=new TreeSet();
		t11.add(new Employee(1,"A"));
		t11.add(new Employee(2,"B"));
		t11.forEach(System.out::println);
		System.out.println("*******************");
		
		Map<Employee, String> t111=new TreeMap();
		t111.put(new Employee(1,"B"), "dd");
		t111.put(new Employee(2,"A"), "kk");
		t111.forEach((k,v)->System.out.println(k+"="+v));
	}

}
class Employee implements Comparable<Employee>{
	private int i;
	private String name;
	
	Employee(int i,String name){
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
		return true;
	}
	public int hashCode(){
		System.out.println("in hashcode");
		return 10;
	}
	@Override
	public String toString() {
		return "Employee [i=" + i + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Employee o) {
		System.out.println(o.getName().compareTo(this.getName()));
		return o.getName().compareTo(this.getName());

	}
	
}
class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}