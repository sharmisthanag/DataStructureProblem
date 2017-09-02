import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("extendstest.txt"));
		obj.writeObject(new B());
		obj.close();

	}

}
class A{
	int a=20;
	A(){
		System.out.println("A");
	}
}
class B extends A implements Serializable{
	int b=10;
	A a=new A();
	B(){
		System.out.println("B");
	}
}
