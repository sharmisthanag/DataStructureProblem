package com.java8.test.flowcontrol;

import java.util.Random;

public class ForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){//initialization only once
			
		}
		/*for(int i=9,j=10;;){
			
		}*/
		/*for(i=10,long l=10;;){//cannot define variable of different datatypes
			
		}*/
		for(int i=10;i>3;i=printmethod()){
			System.out.println(i);
		}
		
		StringBuilder[] ss={new StringBuilder("Java"),new StringBuilder("Loop")};
		for(StringBuilder s:ss){
			//s.append(" Oracle");
			//s=new StringBuilder("yy");
			s=null;
		}
		for(StringBuilder s:ss){
			System.out.println(s);
		}
		
		String[] prog={"paul","shreya","selvan"};
		outer:
		for(String name1:prog){
			for(String name:prog){
				if(name.equalsIgnoreCase("shreya")){
					continue ;
				}
				System.out.println(name);
			}
		}
		
		//
		
		int i=10;
		do{
			while(i<15){
				i=i+20;
			}
		}while(i<2);
		System.out.println(i);

		//
		int i1=10;
		do{
			while(i1++<11){
				System.out.println(i1);
				i1=i1+20;
			}
		}while(i1<2);
		System.out.println(i1);
		
		//
		int a=10;
		if(a++>10){
			System.out.println("true");
		}
		{
			System.out.println("false");
		}
		
		//
		int g=10;
		final int h=20;
		switch(g){
		//case 10*3:System.out.println("ss");break;
		case 10/3:
		//case g:
		default:
			System.out.println("default");
		}
		//
		
		
		byte foo=120;
		switch(foo){
		default:System.out.println("dd");break;
		case 2:System.out.println("kk");break;
		case 120:System.out.println("gg");
		case 127:System.out.println("127");
		case 121:System.out.println("121");break;
		}
		
		//
		
		boolean h1=false;
		if(h1=true){
			System.out.println("if");
		}
		else{
			System.out.println("else");
		}
		//
		int i11=0;
		for(;i11<2;i11=i11+5){
			if(i11<5)continue;
			System.out.println(i11);
		}
		System.out.println(i11);

	}

	private static int  printmethod() {
		Random r=new Random();
		return r.nextInt();
	}

}
