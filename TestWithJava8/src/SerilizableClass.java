
import java.io.*;  
public class SerilizableClass extends Object{  
	public static void main(String args[])throws Exception{  


		FileOutputStream fout=new FileOutputStream("f.txt");  
		ObjectOutputStream out=new ObjectOutputStream(fout);  

		out.writeObject(Student.getInstance());  
		out.flush(); 
		System.out.println("SerializableClass->"+Student.getInstance().id);

		Student.getInstance().id=23;
		System.out.println("SerializableClass->"+Student.getInstance().id);
		System.out.println("success"); 
		System.out.println(Student.getInstance()+","+Student.getInstance().id);
		
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
		  Student s=(Student)in.readObject();  
		  System.out.println(s.id+" "+s.name);  
		  System.out.println("DeserializableClass->"+s);
		  //in.close();  
		  
		
		  
	}  
}  

class Student implements Serializable{  

	private static final long serialVersionUID = 1L;

	int id;  
	String name; 
	Address address;
	public Student(int id, String name) {  
		this.id = id;  
		this.name = name; 
		this.address=new Address("ss", "ss", "sss");
	}
	private Student() throws Exception{
		throw new Exception("Singletion class cannot allow to create instcance");
	}

	private final static Student s=new Student(1, "gg");
	public  static Student getInstance(){
		return s;
	}
	protected Object readResolve() throws ObjectStreamException{
		System.out.println("in read resolve"+Student.getInstance());
		return s;
	}
	Object writeReplace() throws ObjectStreamException {
		System.out.println("in write replace"+Student.getInstance());
		return Student.getInstance();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static Student getS() {
		return s;
	}
}
class Address implements Serializable{  
	String addressLine,city,state;  
	public Address(String addressLine, String city, String state) {  
		this.addressLine=addressLine;  
		this.city=city;  
		this.state=state;  
	}  
} 