package com.pack1;

public class CheckDefaultUsingInstance {
	ClassA a=new ClassA();
	CheckDefaultUsingInstance(){
		a.a =12;
	}
	public void method(){
		//all public protected default members of ClassA is accessible when ClassA is in same package.Import is also not required
		a.b=12;
	}
	

}
