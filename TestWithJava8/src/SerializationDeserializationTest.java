import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/*
 *    Whatever resource we are using should be subtypes of AutoCloseable other wise will get compile time error.

§          The resources which we are using are closed in reverse order means stockQuoteWriter.close() will be called first then stockQuoteReader.close().


Read more: http://javarevisited.blogspot.com/2011/09/arm-automatic-resource-management-in.html#ixzz4ie6rmXVr
 */
public class SerializationDeserializationTest {
	static DemoSingleton instanceOne = DemoSingleton.getInstance();
	public static void main(String[] args) {
		try (FileOutputStream fout=new FileOutputStream("f.txt");
			FileInputStream fin = new FileInputStream("f.txt")){
			// Serialize to a file
			 
			ObjectOutputStream out=new ObjectOutputStream(fout);
			out.writeObject(instanceOne);
			out.close();

			instanceOne.setI(20);

			// Serialize to a file
			ObjectInputStream in=new ObjectInputStream(fin); 
			DemoSingleton instanceTwo = (DemoSingleton) in.readObject();
			in.close();

			System.out.println(instanceOne.getI());
			System.out.println(instanceTwo.getI());
			
			
			//ENUM Serialization check
			
			EnumSerialization obj=EnumSerialization.OBJECT1;
			FileOutputStream fout1=new FileOutputStream("f.txt");  
			ObjectOutputStream out1=new ObjectOutputStream(fout1);
			out1.writeObject(obj);
			out1.close();
			obj.i=20;
			ObjectInputStream in1=new ObjectInputStream(new FileInputStream("f.txt")); 
			EnumSerialization obj1=(EnumSerialization) in1.readObject();
			System.out.println("deserialization => "+obj1.i);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
class DemoSingleton implements Serializable {
	private volatile static DemoSingleton instance = null;

	public static DemoSingleton getInstance() {
		if (instance == null) {
			instance = new DemoSingleton();
		}
		return instance;
	}

	private int i = 10;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	protected Object readResolve() throws ObjectStreamException{
		System.out.println("in read resolve");
		return instance;
	}
}
enum EnumSerialization{
	OBJECT1;
	public int i=10;
	
}
