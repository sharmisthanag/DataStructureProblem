package com.sortingsalgo;

import java.util.Arrays;

public class MergeSortPractice1 {

	public static void main(String[] args) {

		Integer[] arr={3,1,5,8,5,0,2,8,4};
		System.out.println("before mergesort sort"+Arrays.deepToString(arr));
		mergesort(arr);
		System.out.println("afer mergesort sort"+Arrays.deepToString(arr));
	}

	private static void mergesort(Integer[] arr) {
			if(arr.length==1){
				return;
			}
		
			int mid=arr.length/2;	
			Integer[] leftarr=Arrays.copyOfRange(arr, 0, mid);
			Integer[] rightarr=Arrays.copyOfRange(arr, mid, arr.length);
			mergesort(leftarr);
			mergesort(rightarr);
			merge(arr,leftarr,rightarr);
		
	}

	private static void merge(Integer[] arr, Integer[] leftarr, Integer[] rightarr) {
		//lf-379  rg-25887
		int i=0,j=0;
		int positiontoInsert=0;
		while(i<leftarr.length && j<rightarr.length){
			if(rightarr[j]<=leftarr[i]){
				arr[positiontoInsert++]=rightarr[j++];
				continue;
			}
			if(rightarr[j]>=leftarr[i]){
				arr[positiontoInsert++]=leftarr[i++];
				continue;
			}
		}
		
		while(i<leftarr.length){
			arr[positiontoInsert++]=leftarr[i++];
		}
		while(j<rightarr.length){
			arr[positiontoInsert++]=rightarr[j++];
		}
		
			
		
	}

}
