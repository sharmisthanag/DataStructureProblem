package com.java8.test.inheritence;

public class TestCasting {

	public static void main(String[] args) {
		BaseCast b=new DerivedCast();
		NotDerived b1=new DerivedCast();
		BaseCast bc=(BaseCast) b1;
	}

}
interface BaseCast{
	void method();
}
class DerivedCast extends NotDerived implements BaseCast{
	public int j;

	@Override
	public void method() {
		System.out.println(this.j);
		
	}
	
}
class NotDerived{
	
}