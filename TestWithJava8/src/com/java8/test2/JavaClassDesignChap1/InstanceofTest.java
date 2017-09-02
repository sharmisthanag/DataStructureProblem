package com.java8.test2.JavaClassDesignChap1;
/*
 * The instanceof operator is preceded by a value (literal value or a variable name) and
is followed by a class, interface, or enum name
 
  The operator instanceof returns false if the reference variable
being compared to is null.

The instanceof operator never throws a runtime exception; it
returns either true or false. If the instanceof operator uses inconvertible
types, the code won’t compile.
 */
public class InstanceofTest {

	public static void main(String[] args) {

Course c = new Course();
Student s = new Student();
Kid kid =new Kid();
//System.out.println(c instanceof Student);//If the instanceof operator uses inconvertible types, the code won’t compile.
System.out.println(kid instanceof Student);
System.out.println(null instanceof Student);
System.out.println(s instanceof Kid);


	}

}
class Course {}
class Student {}
class Kid extends Student {}
/*
Using instanceof versus getClass in method equals()


The reason to use getClass is to ensure the symmetric property of the equals contract. From equals' JavaDocs:

    It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.

By using instanceof, it's possible to not be symmetric. Consider the example: Dog extends Animal. Animal's equals does an instanceof check of Animal. Dog's equals does an instanceof check of Dog. Give Animal a and Dog d (with other fields the same):

a.equals(d) --> true
d.equals(a) --> false

This violates the symmetric property.

To strictly follow equal's contract, symmetry must be ensured, and thus the class needs to be the same.
*/