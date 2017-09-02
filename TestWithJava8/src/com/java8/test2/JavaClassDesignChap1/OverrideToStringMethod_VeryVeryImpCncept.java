package com.java8.test2.JavaClassDesignChap1;

/*
 * Since instance variable cannot be overridden,so in class CourseBookOverrideToStringMethod have 4 instance variable
 */
public class OverrideToStringMethod_VeryVeryImpCncept {

	public static void main(String[] args) {

		BookOverrideToStringMethod b = new CourseBookOverrideToStringMethod();
		b.title = "Java Smart Apps";
		b.bookCopies=999000;
		System.out.println(b);
	

	}

}
class BookOverrideToStringMethod {
	String title="tukku";
	int bookCopies = 1000;
	@Override
	public String toString() {
		return title + ", Copies:" + bookCopies+" reference"+this.getClass();
	}
}
class CourseBookOverrideToStringMethod extends BookOverrideToStringMethod {
	String title="sharmistha";
	int bookCopies = 9999;
	/*@Override
	public String toString() {
		return title + ", Copies:" + bookCopies+" reference"+this.getClass();
	}*/
}
