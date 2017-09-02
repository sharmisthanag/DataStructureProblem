
public class SquareRootOfANumber {

	public static void main(String[] args) {
		int i=3;
		System.out.println(squareroot(i));

	}

	public static float squareroot(int number) { 
		if (number < 0) return -1; 
		if (number == 0 || number == 1) 
			return number; 
		float start = 0.0f; 
		float end = number; 
		float precision = 0.001f; 
		float middle = start; 
		float difference = number; 
		while (difference >= precision) { 
			middle = (start + end) / 2.0f; 
			System.out.println(middle);
			if (Math.pow(middle, 2) > number) 
			{ 
				end = middle; 
			} 
			else {
				start = middle; 
			} 
			difference = (float) Math.abs(Math.pow(middle, 2) - number); 
		} 
		return middle; 
		
	}

}
