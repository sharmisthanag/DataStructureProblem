package com.sortingsalgo;

import java.util.Arrays;

public class QuickSortPractice1 {

	public static void main(String[] args) {


		Integer[] arr={0,4,8,9,1,6,2,2,7,9,1,11,23,0,0};
		System.out.println("before quicksort sort"+Arrays.deepToString(arr));
		quicksort(arr,0,arr.length-1);
		System.out.println("after quicksort sort"+Arrays.deepToString(arr));




	}

	private static Integer[] quicksort(Integer[] arr, int start, int end) {
		if(start>=end){
			return arr;
		}
		int partitionindex = partition(arr,start,end);
		Integer[] left = quicksort(arr, start, partitionindex-1);
		Integer[] right = quicksort(arr, partitionindex+1, end);
		return arr;
	}

	private static int partition(Integer[] arr, int start, int end) {
		int pivot=arr[end];
		int partionIndex=start;
		for(int i=start;i<end;i++){
			if(arr[i]<=pivot){
				swap(arr,i,partionIndex);
				partionIndex++;
			}
		}
		swap(arr, end, partionIndex);

		return partionIndex;
	}

	private static void swap(Integer[] arr, int i, int partionIndex) {
		if(i!=partionIndex){
			int temp=arr[i];
			arr[i]=arr[partionIndex];
			arr[partionIndex]=temp;
		}

	}

}
