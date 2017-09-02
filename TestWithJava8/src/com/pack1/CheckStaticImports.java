package com.pack1;
import static com.pack1.ClassA.*;

public class CheckStaticImports {
	
	public static void main(String[] args) {
		
		ClassA.r=13;
		m5();
		System.out.println(r);
	}
	

}
