package com.sortingsalgo;

import java.util.Arrays;

public class QuickSortPractice {

	public static void main(String[] args) {

		Integer[] arr={0,4,8,9,1,6,2,2,7,9,1,11,23,0,0};
		System.out.println("before quicksort sort"+Arrays.deepToString(arr));
		quicksort(arr,0,arr.length-1);
		System.out.println("after quicksort sort"+Arrays.deepToString(arr));
		
	
	}

	private static void quicksort(Integer[] arr, int i, int j) {
		if(i>=j)return;
		
		int partitionIndex=partition(arr,i,j);
		quicksort(arr,i,partitionIndex-1);
		quicksort(arr,partitionIndex+1,j);
	}

	private static int partition(Integer[] arr, int start, int end) {
		int partitionIndex=start;
		int pivot=arr[end];
		for(int i=start;i<end;i++){
			if(arr[i]<=pivot){
				swap(arr,partitionIndex,i);
				partitionIndex++;
			}
		}
		swap(arr, partitionIndex, end);
		return partitionIndex;
	}
	private static void swap(Integer[] arr, int i, int j) {
		if(i!=j){
			arr[j]=arr[j]+arr[i];
			arr[i]=arr[j]-arr[i];
			arr[j]=arr[j]-arr[i];
		}
	}
	

}
