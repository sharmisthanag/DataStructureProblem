package com.pack2;

import com.pack1.ClassA;

public class CheckDefaultUsingConstructor extends ClassA{
	
	CheckDefaultUsingConstructor(){
		//only public and protected members of ClassA is available.Import statement is required
	}
	public void method(){
		//only public and protected members of ClassA is available.Import statement is required
	}
}
