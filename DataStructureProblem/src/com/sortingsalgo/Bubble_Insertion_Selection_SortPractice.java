package com.sortingsalgo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Bubble_Insertion_Selection_SortPractice {

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

	private static void insertionsort1(Integer[] arr) {
		//make the left most indices always sorted
		for(int i=1;i<arr.length;i++){
			int position=i;			
			for(int j=i;j>0;j--){
				if(arr[position]<arr[j-1]){
					position=j-1;
					swap(arr,position,j);
				}
			}

		}
	}
	private static void insertionsort(Integer[] arr) {
		//make the left most indices always sorted
		for(int i=1;i<arr.length;i++){
			//int position =i;
			for(int j=i;j>0;j--){
				if(arr[j]>arr[j-1]){
					break;
				}
				if(arr[j]<arr[j-1]){
					swap(arr,j,j-1);
				}

			}
		}
	}

	private static void selectionsort(Integer[] arr) {
		//select the smallest and place it in first position.and do accordingly
		for(int i=0;i<arr.length-1;i++){
			int min=i;			
			for(int j=i+1;j<arr.length;j++){
				if(arr[min]>arr[j]){
					min=j;
				}
			}
			swap(arr,i,min);
		}


	}

	private static void bubblesort(Integer[] arr) {
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					swap(arr,i,j);
				}
			}
		}

	}

	private static void swap(Integer[] arr, int i, int j) {
		if(i!=j){
			arr[j]=arr[j]+arr[i];
			arr[i]=arr[j]-arr[i];
			arr[j]=arr[j]-arr[i];
		}
	}

}
