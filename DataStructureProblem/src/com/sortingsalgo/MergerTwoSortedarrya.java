package com.sortingsalgo;

import java.util.Arrays;
import java.util.List;


public class MergerTwoSortedarrya {

	public static void main(String[] args) {
		Integer[] left={1,4,6,8};
		Integer[] right={1,2,6,7,8,9};
		Integer[] i= merge(left,right);
		List l= Arrays.asList(i);
		l.forEach(System.out::println);
		System.out.println(Arrays.asList(i));
	}

	private static Integer[] merge(Integer[] left, Integer[] right) {
		Integer[] ii=new Integer[left.length+right.length];
		//int[] ii=new int[left.length+right.length];
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<left.length && j<right.length){
			if(left[i]<=right[j]){
				ii[k++]=left[i++];continue;
			}
			if(left[i]>=right[j]){
				ii[k++]=right[j++];continue;
			}
		}
		while(i<left.length){
			ii[k++]=left[i++];
		}
		while(j<right.length){
			ii[k++]=right[j++];
		}
		return ii;
		
	}

}
