package com.java8.test2.JavaClassDesignChap2;

import java.io.File;
import java.io.FileNotFoundException;

/*
 * Static variables belong to a class and are shared by all its instances. Their value is the same for all instances of their class.

You can define variables, methods, nested classes, and nested interfaces as static members.
They belong to a class and not to instances. They can be accessed soon after
their class is loaded into memory. Top-level classes, interfaces, and enums can’t be
defined as static entities.

for the existence of a static initializer block is to add values (static or
dynamic) to collection objects that have already been initialized.

Code in a static initializer block executes when a class is loaded in memory by JVM—
before creation of its instances.

static block cannot throw any exception or cannot assign value to a variable by calling a method which throws checked exception 
 On the exam, beware of code that defines multiple initializer
blocks. If a class defines multiple initializer blocks, they execute in the
order of their appearance in a class.

 */
public class StaticUnderstanding {
	static{
		System.out.println(StaticUnderstanding.j);//removig StaticUnderstanding will show error
		++StaticUnderstanding.j;//Removing StaticUnderstanding will show error ,"Cannot reference a field before it is defined"
	}
	static int j; 
	static{
		j++;
	}
	public static void main(String[] args) {

		new StaticInitBlocks();
		StaticInitBlocks.modifyStaticVar();
		new StaticInitBlocks();

		System.out.println("j=>"+j);
	}

}
/*class AffiliateProgram {
	private static int accountOpenBonus = initAccountOpenBonus();//Unhandled exception type FileNotFoundException
	private static int initAccountOpenBonus() throws FileNotFoundException
	{
		return 12;
	}
}*/
class AffiliateProgram {
	private static int accountOpenBonus;

	private static int initAccountOpenBonus() throws FileNotFoundException{
		File f=new File("hhh.txt");
		return accountOpenBonus;
	}
	static {
		try {
			accountOpenBonus = initAccountOpenBonus();
		}
		catch (FileNotFoundException e) {
			//.. relevant code
		}
	}
}
class StaticInitBlocks {
	static int staticVar = 10;
	static {
		System.out.println("First");
		++staticVar;
	}
	static {
		System.out.println("Second");
		++staticVar;
	}
	public static void modifyStaticVar() {
		++staticVar;
	}
	public StaticInitBlocks() {
		System.out.println("Constructor:" + staticVar);
	}
}

class DemoMultipleStaticBlocks {
	static {
	//	++staticVar;//Cannot reference a field before it is defined
	}
	static int staticVar =0;
	static {
		++staticVar;
	}
	public DemoMultipleStaticBlocks() {
		System.out.println("Constructor:" + staticVar);
	}
	public static void main(String args[]) {
		new DemoMultipleStaticBlocks();
	}
}

class AssignManipulateStaticVariable {
	static {
		rate = 10;
	}
	static int rate = 0;
	static {
		++rate;
	}
	public AssignManipulateStaticVariable() {
		System.out.println(rate);
	}
	public static void main(String args[]) {
		new AssignManipulateStaticVariable();
	}
}