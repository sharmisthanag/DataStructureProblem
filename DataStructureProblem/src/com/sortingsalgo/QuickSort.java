package com.sortingsalgo;

import java.util.Arrays;

public class QuickSort {
	static{
		Integer i=10;
		synchronized(i){
			
		}
	}

	public static void main(String[] args) {
		int s=10;
		Integer[] arr={0,4,8,9,1,6,2,2,7,9,1,11,23,0,0};
		System.out.println("before quicksort sort"+Arrays.deepToString(arr));
		quicksort(arr,0,arr.length-1);
		System.out.println("after quicksort sort"+Arrays.deepToString(arr));
		
	
	}

	private static void quicksort(Integer[] arr,int start,int end) {
		if(start<end){		
			int partitionIndex = partition(arr,start,end);
			quicksort(arr,start,partitionIndex-1);
			quicksort(arr,partitionIndex+1,end);
		}
		
	}

	private static int partition(Integer[] arr, int start, int end) {
		int partionIndex=start;
		int partionValue = arr[end];
		for(int i=start;i<end;i++){
			if(arr[i]<=partionValue){
				swap(arr,partionIndex,i);
				partionIndex++;
			}
		}
		swap(arr,partionIndex,end);
		System.out.println(Arrays.deepToString(arr));
		return partionIndex;
		
		
	}

	private static void swap(Integer[] arr, int partionIndex, int end) {
		if(partionIndex != end){
			int temp=arr[partionIndex];
			arr[partionIndex]=arr[end];
			arr[end] = temp;
		}
		
	}

}
