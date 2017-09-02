package com.java8.test2.JavaClassDesignChap2;

/*
 * Interestingly, you can survive code with an uninitialized final local variable, if you
don’t use it

If a static or instance variable is marked final, it must be initialized,
or the code won’t compile.
 */
public class FinalVariable {

	private final int v;
	//not allowed 
	/*static{
		v=10;//Cannot make a static reference to the non-static field v
	}
	 */

	//allowed
	{
		v=19;//iffinal variable is initialized in instance block then,cinitializing of final variable is not allwed in its constructor
	}
	FinalVariable(){
		v=10;
	}
	FinalVariable(int v){
		this.v=v;
	}

}
class MyClass {
	void setValue(final int finalMethodParam) {
		finalMethodParam = 10;//The final local variable finalMethodParam cannot be assigned. It must be blank and not using a compound assignment
	}
}
class MyClass1 {
	void addCondition(final StringBuilder query) {
		query.append("WHERE id > 500");//Can modify object referred to by Won’t compile; can’t reassign variable query.
		query = new StringBuilder("SELECT name FROM emp");//Won’t compile; can’t reassign variable query.another object to reference variable query.
	}
	/*
	 * the Java compiler will consider initialization of a final variable complete only if the
initialization code will execute in all conditions

	 */
	class MyClass2 {
		final int finalVar;
		/*not allowed
		 MyClass2(double a, double b) {
			if (a > b)
				finalVar = 20;
			else if (b >= a)
				finalVar = 30;
		}*/
		//allowed
		MyClass2(double a, double b) {
			if (a>b)
				finalVar = 20;
			else
				finalVar = 30;
		}
	}
}