package com.sortingsalgo;

import java.util.Arrays;

public class Bubble_Selection_Insertion_Sort {

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
		for(int i=0;i<arr.length-1;i++){
			int j=i;
			while(j>=0){
				if(arr[j+1]<arr[j]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				j--;
			}
			
		}
		
	}

	private static void selectionsort(Integer[] arr) {
		for(int i=0;i<arr.length-1;i++){
			int minPos=i;
			int value=arr[i];
			for(int j=i+1;j<arr.length;j++){
				if(value>arr[j]){
					minPos=j;
					value=arr[j];
				}				
			}
			if(i!=minPos){
				int temp=arr[i];
				arr[i]=value;
				arr[minPos]=temp;
			}			
		}
		
	}

	private static void bubblesort(Integer[] arr) {
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
		}
		
	}

}
