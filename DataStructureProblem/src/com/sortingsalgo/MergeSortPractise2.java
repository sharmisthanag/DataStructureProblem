package com.sortingsalgo;

import java.util.Arrays;

public class MergeSortPractise2 {

	public static void main(String[] args) {
		Integer[] arr={3,1,5,8,5,0,2,8,4};
		System.out.println("before mergesort sort"+Arrays.deepToString(arr));
		mergesort(arr);
		System.out.println("afer mergesort sort"+Arrays.deepToString(arr));
	

	}

	private static Integer[] mergesort(Integer[] arr) {
		if(arr!=null && arr.length ==1)return arr;
		
		int mid=arr.length/2;
		Integer[] leftarr=Arrays.copyOfRange(arr, 0, mid);
		Integer[] rightarr=Arrays.copyOfRange(arr, mid, arr.length);
		mergesort(leftarr);
		mergesort(rightarr);
		merge(arr,leftarr,rightarr);		
		return arr;
		
	}

	private static void merge(Integer[] arr, Integer[] leftarr, Integer[] rightarr) {
		int i=0;int j=0;int k=0;
		while(i<leftarr.length && j<rightarr.length){
			if(leftarr[i]<=rightarr[j]){
				arr[k++] = leftarr[i++];continue;
			}
			/*if(rightarr[j] <= leftarr[i] ){
				arr[k++]=rightarr[j++];continue;
			}*/
			else{
				arr[k++]=rightarr[j++];continue;
			}
		}
		while(i<leftarr.length){
			arr[k++]=leftarr[i++];
		}
		while(j<rightarr.length){
			arr[k++]=rightarr[j++];
		}
		
	}

}
