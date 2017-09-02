import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int h= Integer.parseInt(s.nextLine());
		int x=10;
		for(;x<1000;x++){
			boolean prime=true;
			int i=2;
			for(;i<x/2;i++){
				if(x%i==0){
					prime=false;System.out.println(x+"divided by +"+i);
					break;
				}
			}
			if(prime==true){
				System.out.println(x+"you are a prime number");
			}
			
		}
	}
}


