package com.sortingsalgo;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] arr={3,1,5,8,5,0,2,8,4};
		System.out.println("before mergesort sort"+Arrays.deepToString(arr));
		mergesort(arr);
		System.out.println("afer mergesort sort"+Arrays.deepToString(arr));
		
	}

	private static void mergesort(Integer[] arr) {
		int length=arr.length;		
		if(arr.length<2){
			return ;
		}
		int mid=arr.length/2;
		Integer[] left = new Integer[mid];
		Integer[] right = new Integer[length-mid]; 
		left=Arrays.copyOfRange(arr, 0, mid);
		right = Arrays.copyOfRange(arr, mid, length);
		mergesort(left);
		mergesort(right);
		merge(left,right,arr);		
	}

	private static void merge(Integer[] left, Integer[] right, Integer[] arr) {
		int i=0;
		int j=0;
		int k=0;
				
		while(i<left.length && j<right.length){
			if(left[i]>=right[j]){
				arr[k]=right[j];
				j++;
			}
			else if(left[i]<=right[j]){
				arr[k]=left[i];
				i++;
			}
			k++;			
		}
		if(i==left.length && j!=right.length){
			while(j<right.length){
				arr[k]=right[j];
				j++;
				k++;
			}
		}
		else if(i!=left.length && j==right.length){
			while(i<left.length){
				arr[k]=left[i];
				i++;
				k++;
			}				
		}
		left=null;
		right=null;
		
	}

}
