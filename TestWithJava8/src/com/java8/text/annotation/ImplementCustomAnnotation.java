package com.java8.text.annotation;

import java.lang.reflect.Method;

public class ImplementCustomAnnotation {
	 @CustomAnnotation(key="site", value="java2novice.com")
	    public void myAnnotationTestMethod(){
	         
	        try {
	            Class<? extends ImplementCustomAnnotation> cls = this.getClass();
	            Method mth = cls.getMethod("myAnnotationTestMethod");
	            CustomAnnotation myAnno = mth.getAnnotation(CustomAnnotation.class);
	            System.out.println("key: "+myAnno.key());
	            System.out.println("value: "+myAnno.value());
	        } catch (SecurityException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (NoSuchMethodException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	     
	    public static void main(String a[]){
	         
	    	ImplementCustomAnnotation mat = new ImplementCustomAnnotation();
	        mat.myAnnotationTestMethod();
	    }
	    @Override
}
