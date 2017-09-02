package com.java8.test2.ThreadChap11.Concurrency.Executorss;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoin {

	public static void main(String[] args) {
		int[] ii=new int[100];
		for(int i=0;i<ii.length;i++){
			ii[i]=i;
		}
		
		long start=System.currentTimeMillis();

		ForkJoinPool fjp = new ForkJoinPool(10);
		CalculateSum clsum=new CalculateSum(ii, 0, 100,"main");
		System.out.println(fjp.invoke(clsum));
		
		System.out.println("array created=>"+(System.currentTimeMillis()-start));

	}

}
class CalculateSum extends RecursiveTask<Integer>{
	int unit=20;
	int[] values;
	int start;
	int end;
	String name;
	CalculateSum(int[] values,int start,int end,String name){
		this.values=values;
		this.start=start;
		this.end=end;
		this.name=name;
	}

	@Override
	protected Integer compute() {
		final int currentSize = end - start;
		if(currentSize<unit){
			return computeSum();
		}
		int mid = currentSize/2;
		CalculateSum leftsum=new CalculateSum(values, start, start+mid,"left");
		leftsum.fork();
		
		CalculateSum rightsum = new CalculateSum(values, start+mid, end,"right");
		return rightsum.compute()+leftsum.join();
		//return leftsum.invoke()+rightsum.invoke();
	}

	private Integer computeSum() {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += values[i];
		}
		System.out.println(Thread.currentThread().getName()+": Sum(" + start + "-" + end + "):" + sum+"=>name:"+name);
		return sum;
	}

}