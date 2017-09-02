public class PrintEvenBetweenRange {

	public static void main(String[] args) {
		int upperLimit=13;
		int lowerLimit=2;
		printEven(upperLimit,lowerLimit);

	}

	private static void printEven(int upperLimit, int lowerLimit) {
		int length=getLengthofEven(upperLimit,lowerLimit);
		System.out.println(length);
		int[] arr=new int[length];
		int j=0;
		for(int i=lowerLimit;i<=upperLimit;i++){
			if((i&1)==0){
				arr[j++]=i;System.out.println(i);}
		}

	}

	private static int getLengthofEven(int upperLimit, int lowerLimit) {
		if((lowerLimit&1)==1){
			lowerLimit--;
		}
		if((upperLimit&1)==1){
			upperLimit++;
		}
		
		return (upperLimit-lowerLimit)/2;
	}
	


}
