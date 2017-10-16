package com.java8.test.datatypes;
import java.lang.reflect.Field;

//https://stackoverflow.com/questions/11700320/is-string-literal-pool-a-collection-of-references-to-the-string-object-or-a-col/11701016#11701016
public class StringAnalysis {

    private int showInternalCharArrayHashCode(String s)
            throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException {
        final Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
       // return value.get(s).hashCode();
        return System.identityHashCode(value.get(s));
    }

    public void printStringAnalysis(String s) throws SecurityException,
            IllegalArgumentException, NoSuchFieldException,
            IllegalAccessException {
        System.out.println(showInternalCharArrayHashCode(s));

        System.out.println(System.identityHashCode(s));

    }

    public static void main(String args[]) throws SecurityException,
            IllegalArgumentException, NoSuchFieldException,
            IllegalAccessException, InterruptedException {
        StringAnalysis sa = new StringAnalysis();
        String s1 = new String("myTestString");
        String s2 = new String("myTestString");
        String s3 = s1.intern();
        String s4 = "myTestString";

        System.out.println("Analyse s1");
        sa.printStringAnalysis(s1);

        System.out.println("Analyse s2");
        sa.printStringAnalysis(s2);

        System.out.println("Analyse s3");
        sa.printStringAnalysis(s3);

        System.out.println("Analyse s4");
        sa.printStringAnalysis(s4);

    }

}