package com.java8.test.datatypes;

public class ff {
	final int po;
	ff(){
		System.out.println("jjj");
		this.po=10;
	}
	
	ff(int j){
		this.po=j;
	}
	public int getPO(){
		return this.po;
	}
	
	/*public void setPO(int po){
		this.po=po;
	}*/
	public static void main(String[] args){
		
		ff g=new ff(10);
		//1
		int basedecimal = 267;
		int octal = 0413;
		int hexval = 0X10B;
		int binval = 0b100001011;
		System.out.println(basedecimal+octal);
		System.out.println(hexval+binval);
		//2
		long l = 1_07__07;
		System.out.println("**l"+l);
		//3
		char c11=122;
		char c1='\u0122';
		System.out.println(c11);System.out.println(c1);
		char c2=(char)-122;
		System.out.println(c2);
		//4
		int myInt=10;
		boolean  result= true;
		if(result == true){
			do
				System.out.println("myInt");
			while (myInt>10);
		}
		//5
		int o=9;int h=12;
		System.out.println(o=h);
		//6
		boolean b1,b2,b3,b4,b5;
		b1=b2=b3=true;

		//7
		final byte l1=127;
		final byte l11=127;
		//byte s=l1+l11;
		
		//8
		
		int a=10,b=20,c=40;
		System.out.println(a++==10 && b++!=20 && c++==40 && a++==11);
		System.out.print(a);System.out.print(b);System.out.println(c);

		
		System.out.println(true || false && false && true);
		System.out.println(true || false && false ||false);
		System.out.println(false || true || false ||true);
		System.out.println(false && true ||true && true);
		System.out.println(true && false && true && false);
		
		//After true ,if any condition have && operator it will be dead code till it finds next OR operation
		
		//9
		int myChar =97;
		int yourChar =98;
		System.out.println((char)myChar+(char)yourChar);//195
		System.out.println((char)myChar+""+(char)yourChar);//ab
		//10\
		char a1='a';
		//char a11=-10;
		char a111='1';
		System.out.println(++a1+""+(++a111));
		//11
		int o1=10;
		long o2=20;
		short o3=30;
		System.out.println(++o1 + o2++ * o3);
		//12
		Boolean bb=new Boolean(true);
		Boolean bb1=new Boolean(true);
		System.out.println(bb==bb1);
		
		Boolean bb2=bb.booleanValue();
		Boolean bb3=bb1.booleanValue();
		System.out.println(bb2==bb3);
		System.out.println(!bb2);
		System.out.println(bb && bb1);
		//13
		long ddd=0x10C;short ss=0512;double ggg=10;byte bb11=-0;long lk=999999999;
		System.out.println("**b=>"+bb11);
		//14
		int ctr=50;
		//ctr+=1;
		//ctr++;
		//ctr=+1;prints 1 o ctr
		System.out.println(ctr%20);
		//15
		int f=10;int ff=20;
		int fff = (f*(ff+2)) - 10-4 * ((2*2)-6);//218
		System.out.println(fff);
		//16
		boolean ret= 10>=10 && 17.8f<4.567 || true ;
		System.out.println(ret);
		
		float ffff=12.2f;
		boolean bol=false;
		System.out.println(f=(int) ffff);
		System.out.println(bol=false);
		
	}

}
