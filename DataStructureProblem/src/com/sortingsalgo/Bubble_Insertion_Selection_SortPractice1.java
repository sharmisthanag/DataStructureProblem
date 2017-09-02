package com.sortingsalgo;

import java.util.Arrays;

public class Bubble_Insertion_Selection_SortPractice1 {

	public static void main(String[] args) {


		Integer[] arr={3,1,5,8,5,0,2};
		System.out.println("before bubble sort"+Arrays.deepToString(arr));
		bubblesort(arr);
		System.out.println("afer bubble sort"+Arrays.deepToString(arr));
		
		
		arr=new Integer[]{3,1,5,8,5,0,2};
		System.out.println("before selection sort"+Arrays.deepToString(arr));
		selectionsort(arr);
		System.out.println("afer selection sort"+Arrays.deepToString(arr));
		
		
		arr=new Integer[]{3,1,5,8,5,0,2};
		System.out.println("before insertion sort"+Arrays.deepToString(arr));
		insertionsort(arr);
		System.out.println("afer insertion sort"+Arrays.deepToString(arr));
		
		



	}
	private static void insertionsort(Integer[] arr) {
		//leftmost arr will always be sorted
		for(int i=1;i<arr.length;i++){
			int position=i;
			for(int j=i-1;j>=0;j--){
				if(arr[position] > arr[j])break;
				if(arr[position]<arr[j]){
					swap(arr, j, position--);
				}
			}
			
		}
		
	}
	private static void selectionsort(Integer[] arr) {
		//select the minimum and place it at first position
		/*for(int i=0;i<arr.length;i++){
			int min=arr[i];
			for()
		}*/
		
		
	}
	private static void bubblesort(Integer[] arr) {
		
		
	}
	private static void swap(Integer[] arr, int i, int j) {
		if(i!=j){
			arr[j]=arr[j]+arr[i];
			arr[i]=arr[j]-arr[i];
			arr[j]=arr[j]-arr[i];
		}
	}

}
