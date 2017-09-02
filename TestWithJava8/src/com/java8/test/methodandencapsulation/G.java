package com.java8.test.methodandencapsulation;

public class G extends H{
	int param;
	int param1;
	
	G(){
		super(10);
		System.out.println("in G cons");
	}
	G(int a){
		this();
		System.out.println("in G cons");
	}
	void G(){
		System.err.println("in  G constructor");
	}


	public static void main(String[] args) {
		G g=new G(); 
		g.param=10;
		
		g.method(g.param);
		
		//1
		method1(1,2,3);

	}
	public void method(int param){
		int param1;
		
		System.out.println(this.param);
		
	}
	public static void method1(int year,int... i){
		for(int ii:i){
			System.out.println(ii);
		}
	}

}
class H{
	H(int a){
		System.out.println("hello");
	}
}
