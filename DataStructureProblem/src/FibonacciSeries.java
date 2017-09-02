import java.util.ArrayList;

public class FibonacciSeries {
	//1,1,2,3,5,8,13,21
	public static void main(String[] args) throws CloneNotSupportedException {
		int count=5;
		printFibonacci(count);
		System.out.println("***************");
		for (int i = 1; i <= count; i++) {
			System.out.println(fibonacciRecusion(i) + " ");
		}
		/*FibonacciSeries f=new FibonacciSeries();
		//f=(FibonacciSeries) f.clone();

		ArrayList a=new ArrayList();
		a.add("h");*/
	}



	private static void printFibonacci(int count) {
		int pre=1;
		int sum=0;
		if(count==1){
			System.out.println(pre);		
		}
		else{
			for(int i=0;i<count;i++){
				//System.out.println("pre="+pre+"/sum="+sum);
				
				sum=pre+sum;
				System.out.println(sum);
				pre=sum-pre;	
			}
		}


	}
	public static int fibonacciRecusion(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}

		return fibonacciRecusion(number - 1) + fibonacciRecusion(number - 2); // tail recursion
	}


}
