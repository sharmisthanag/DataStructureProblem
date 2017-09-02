package com.java8.test.inheritence;

class AnimalS {
void jump() { System.out.println("Animal"); }
}
class Cat extends AnimalS {
void jump(int a) { System.out.println("Cat"); }
}
class Rabbit extends AnimalS {
void jump() { System.out.println("Rabbit"); }
}
public class Circus{
public static void main(String args[]) throws Exception{
AnimalS cat = new Cat();
Rabbit rabbit = new Rabbit();
cat.jump();
rabbit.jump();
}
}
