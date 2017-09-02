package com.sortingsalgo;

import java.util.Arrays;

public class QuickSortPractice2 {

	public static void main(String[] args) {


		Integer[] arr={0,4,8,9,1,6,2,2,7,9,1,11,23,0,0};
		System.out.println("before quicksort sort"+Arrays.deepToString(arr));
		quicksort(arr,0,arr.length-1);
		System.out.println("after quicksort sort"+Arrays.deepToString(arr));




	}

	private static void quicksort(Integer[] arr, int start, int end) {
		if(start>=end)return;
		int partitionIndex = partition(arr,start,end);
		quicksort(arr,start,partitionIndex-1);
		quicksort(arr, partitionIndex+1, end);

	}

	private static int partition(Integer[] arr, int start, int end) {
		int pivot=arr[end];int partitionIndex=start;
		while(start<end){
			if(pivot >= arr[start]){
				swap(arr,partitionIndex,start);
				partitionIndex++;
			}
			start++;
		}
		swap(arr,partitionIndex,end);
		return partitionIndex;
	}

	private static void swap(Integer[] arr, int partitionIndex, int start) {
		if(partitionIndex == start) return;
		int temp = arr[start];
		arr[start] = arr[partitionIndex];
		arr[partitionIndex] = temp;
	}

}
