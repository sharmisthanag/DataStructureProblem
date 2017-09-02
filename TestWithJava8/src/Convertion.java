import java.util.Scanner;

public class Convertion {
	private static int base =2;
	public static void main(String[] args) {
		int i=0;
		System.out.println("Enter number ?");
		Scanner in= new Scanner(System.in);
		Integer s = Integer.parseInt(in.nextLine());
		System.out.println(convert(s));

	}

	private static String convert(Integer number) {
		if(number ==0){
			return "";
		}
		return convert(number/base) +""+number%base;
	}

}
