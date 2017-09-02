// Java code to find number of days after which
// tank will become empty
public class Tank_Empty {
	
	// Utility method to get sum of first n numbers
	static int getCumulateSum(int n)
	{
		return (n * (n + 1)) / 2;
	}
	
	// Method returns minimum number of days after 
	// which tank will become empty
	static int minDaysToEmpty(int C, int l)
	{
		// if water filling is more than capacity then
		// after C days only tank will become empty
		if (C <= l) 
			return C; 
	
		// initialize binary search variable
		int lo = 0;
		int hi = (int)1e4;
		int mid;
	
		// loop until low is less than high
		while (lo < hi) {
			
			mid = (lo + hi) / 2;
	
			// if cumulate sum is greater than (C - l) 
			// then search on left side
			if (getCumulateSum(mid) >= (C - l)) 
				hi = mid;
			
			// if (C - l) is more then search on
			// right side
			else
				lo = mid + 1;	 
		}
	
		// final answer will be obtained by adding
		// l to binary search result
		return (l + lo);
	}
	
	// Driver code to test above methods
	public static void main(String args[])
	{
		int C =9999999;
		int l = 99;
	
		System.out.println(minDaysToEmpty(C, l));
	}
}
// This code is contributed by Sumit Ghosh
