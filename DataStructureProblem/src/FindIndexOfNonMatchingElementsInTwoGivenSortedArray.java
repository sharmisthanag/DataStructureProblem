public class FindIndexOfNonMatchingElementsInTwoGivenSortedArray
{

	static int findExtra(int arr1[], int arr2[])
	{

		int length=arr1.length>arr2.length?arr1.length:arr2.length;
		int start=0;
		int end=length-1;
		int mid=0;
		while(start<end){//3,2
			mid=(end+start)/2;//3,1

			if(arr1[mid]==arr2[mid]){
				start=mid+1;//2
			}
			else{
				end=mid;//2
			}

		}
		return start;

	}

	public static void main (String[] args)
	{
		int arr1[] = {2,4,6,10,12,14};
		int arr2[] = {2,4,6,12,14};

		// Solve is passed both arrays
		System.out.println(findExtra(arr1, arr2));
	}
}