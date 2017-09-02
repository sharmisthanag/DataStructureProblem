package com.java8.test.inheritence;


class Emmployeee {
String name = "Emp";
String address = "EmpAddress";
}
class Programmerr extends Emmployeee{
String name = "Prog";
void printValues() {
System.out.print(this.name + ":");
System.out.print(this.address + ":");
System.out.print(super.name + ":");
System.out.print(super.address);
}
}
public class ThisSuper {
public static void main(String args[]) {
new Programmerr().printValues();
}
}