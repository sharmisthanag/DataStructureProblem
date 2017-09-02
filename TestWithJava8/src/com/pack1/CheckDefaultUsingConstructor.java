package com.pack1;

public class CheckDefaultUsingConstructor extends ClassA{
	CheckDefaultUsingConstructor(){
		a = 12;
		
		
		//all public protected default members of ClassA is accessible when ClassA is in same package.Import is also not required
	}
	public void method(){
		a=12;
	}

}
