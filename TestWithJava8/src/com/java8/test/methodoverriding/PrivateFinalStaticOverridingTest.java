package com.java8.test.methodoverriding;

public class PrivateFinalStaticOverridingTest {
	 
    public static void main(String args[]) {
 
        // Reference variable of type Base - Object of type Derived
        Base b = new Derivedd();
     
        System.out.println(b.version());
        System.out.println(b.name());
     //   System.out.println(b.where);
           
    }    
 
}

/**
  * Base Class which contains three methods with final, static, and private
  * modifier, to show that these method can't be overridden in Java.
  *
  * @author Javin
  */
class Base{
 
    public String version(){
        where(); // This will call Base class where() method
        return "1.0.0";
    }
 
    public static String name(){
        return "Base";
    }
 
    private void where(){
    	
        System.out.println("Inside Base Class");
    }
}

/**
  * Derived Class, which extends Base and tries to override final, static
  * and private methods in Java.

  * @author Javin
  */
class Derivedd extends Base{
 
    // Compilation Error : Final method can't be overridden in Java
    public final String version(){
        return "2.0.0";
    }
 
    // Hidden static method - Same Signature but bonded at compile time
    public static String name(){
        return "Derived";
    }
 
    // Hidden private method - Same signature but resolved at compile time
    private void where(){
        System.out.println("Inside Derived Class");
    	super.version();

    }
    private void fff(){
    	super.version();
    }
}


