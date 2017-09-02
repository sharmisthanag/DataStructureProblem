
public class NewInstance {

	public static void main(String[] args) {
		try {
			Object o=Class.forName("Student123").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student s=new Student();
		try{
			
		}
		finally{
			
		}
	}

}
class Student{
	Student(){
		System.out.println("default consturctor");
	}
	
}