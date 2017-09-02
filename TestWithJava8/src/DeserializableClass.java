
import java.io.*;  
public class DeserializableClass{  
 public static void main(String args[])throws Exception{
	 
	 ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
	  Student s=(Student)in.readObject();  
	  System.out.println(s.id+" "+s.name);  
	  System.out.println("DeserializableClass->"+s);
	  in.close(); 
	  
	  ObjectInputStream in1=new ObjectInputStream(new FileInputStream("f.txt")); 
		EnumSerialization obj1=(EnumSerialization) in1.readObject();
		System.out.println("deserialization => "+obj1.i);
 }  
}