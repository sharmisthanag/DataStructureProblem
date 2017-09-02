
public class AddTwoNumber {

	public static void main(String[] args) {
		add(10,15);

	}

	private static void add(int a, int b) {
		while(b!=0){
			int carry= a & b;
			a = a ^ b;
			b= carry <<1;
			
		}
		System.out.println(a);
	}

}
