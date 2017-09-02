package com.java8.test.exceptions;

/*
public class HandlingError {
	static int  count=0;
public static void main(String args[]) {
try {
myMethod();
} catch (StackOverflowError s) {
System.out.println(s+""+count);
}
}
public static void myMethod() {
System.out.println("myMethod"+count++);
myMethod();
}
}*/

/*public class HandlingError {
public static void main(String args[]) {
try {
myMethod();
} catch (StackOverflowError s) {
for (int i=0; i<2; ++i)
System.out.println(i);
}
}
public static void myMethod() {
myMethod();
}
}*/

class Ink{}
interface Printable {}
class ColorInk extends Ink implements Printable {}
class BlackInk extends Ink{}
public class HandlingError {
public static void main(String args[]) {
Printable printable = null;
BlackInk blackInk = new BlackInk();
printable = (Printable)blackInk;
}
}