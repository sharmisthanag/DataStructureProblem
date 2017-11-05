package com.java8.test2.ThreadChap10;

public class Mutable extends Immutable {
    private int realValue;

    public Mutable(int value) {
        super(value);

        realValue = value;
    }

    public int getValue() {
        return realValue;
    }
    public void setValue(int newValue) {
        realValue = newValue;
    }

   public static void main(String[] arg){
       Mutable obj = new Mutable(4);
       Immutable immObj = (Immutable)obj;              
       System.out.println(immObj.getValue());
       obj.setValue(8);
       System.out.println(immObj.getValue());
       
       //
       Immutable im=new Immutable(10);
       Mutable m=(Mutable)im;
       System.out.println(im.getValue());
   }
}
class Immutable {
    private final int value;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}