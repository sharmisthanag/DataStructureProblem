package com.searching;

public class BinarySearch {
	 public static void main(String args[])
	    {
	        BinarySearch ob = new BinarySearch();
	        int arr[] = {2,3,4,10,40};
	        int n = arr.length;
	        int x = 10;
	        int result = ob.binarySearch(arr,0,n-1,x);
	        if (result == -1)
	            System.out.println("Element not present");
	        else
	            System.out.println("Element found at index "+result);
	    }

	private int binarySearch(int[] arr, int start, int end, int x) {
		if(end>0){
			int mid=start + (end-start)/2;
			if(arr[mid] == x){
				return mid;
			}
			if(x < arr[mid]){
				return binarySearch(arr, start, mid-1, x);
			}
			else{
				return binarySearch(arr, mid+1, end, x);
			}
		}
		return -1;
	}
}
