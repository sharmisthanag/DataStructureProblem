package com.sortingsalgo;

import java.util.Arrays;

public class MergeSortPractice {

	public static void main(String[] args) {

		Integer[] arr={3,1,5,8,5,0,2,8,4};
		System.out.println("before mergesort sort"+Arrays.deepToString(arr));
		mergesort(arr);
		System.out.println("afer mergesort sort"+Arrays.deepToString(arr));
	}

	private static Integer[] mergesort(Integer[] arr) {
		if(arr.length==1){
			return arr;
		}
		int mid=arr.length/2;
		Integer[] left=Arrays.copyOfRange(arr, 0, mid);
		Integer[] right=Arrays.copyOfRange(arr, mid, arr.length);
		mergesort(left);
		mergesort(right);
		merge(left,right,arr);		
		return arr;		
	}

	private static Integer[] merge(Integer[] left, Integer[] right, Integer[] arr) {
		int index=0;
		int leftindex=0;
		int rightindex=0;
		
		while(leftindex<left.length && rightindex<right.length){
			if(right[rightindex]<=left[leftindex]){
				arr[index++]=right[rightindex];
				rightindex++;
			}
			else if(left[leftindex]<=right[rightindex]){
				arr[index++]=left[leftindex];
				leftindex++;
			}
			System.out.println(Arrays.deepToString(arr));
		}
		while(leftindex<left.length){
			arr[index++]=left[leftindex];
			leftindex++;
			System.out.println(Arrays.deepToString(arr));
		}
		while(rightindex<right.length){
			arr[index++]=right[rightindex];
			rightindex++;
			System.out.println(Arrays.deepToString(arr));
		}
		
		return arr;
	}

}
