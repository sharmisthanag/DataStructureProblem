package com.java8.test2.JavaClassDesignChap2;

/*
 * An enum can define a main method. This means that you can define an enum
as an executable Java application.
■ The enum constant list must be defined as the first item in an enum, before the
declaration or definition of methods and variables.
 */
public enum EnumTwist {
	HELLO,LOLLO{
		public void print(){
			System.out.println(this.name());
		}

	};
	public static void main(String[] args) {
		EnumTwist.LOLLO.print();
		EnumTwist.HELLO.print();

	}
	EnumTwist(){

	}
	EnumTwist(int i){

	}
	public void print(){
		System.out.println(this.ordinal());
	}

}


//Implicit functionalit
/*final class Level extends Enum
{
	public static final Level BEGINNER;
	public static final Level INTERMEDIATE;
	public static final Level EXPERT;
	private static final Level $VALUES[];
	static
	{
		BEGINNER = new Level("BEGINNER", 0);
		INTERMEDIATE = new Level("INTERMEDIATE", 1);
		EXPERT = new Level("EXPERT", 2);
		$VALUES = (new Level[] {
				BEGINNER, INTERMEDIATE, EXPERT
		});
	}
	public static Level[] values()
	{
		return (Level[])$VALUES.clone();
	}
	public static Level valueOf(String s)
	{
		return (Level)Enum.valueOf(Level, s);
	}
	private Level(String s, int i)
	{
		super(s, i);
	}
}
*/