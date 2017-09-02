import java.util.ArrayList;
import java.util.List;

public class rough extends ARough{

	public static void main(String[] args) {
		//1
		int ghg[]=new int[10];
		
		try{
		System.out.println("ddd"+ghg[12]);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("gg"+e.getLocalizedMessage());
		}
		//2
				//int g[]=new int[-2];
		Runnable r=new Runnable(){

			@Override
			public void run() {
				System.out.println("run");
				
			}
			
		};
			Runnable rr = ()->{System.out.println("run");};	
		//3
		int sum=0;
		int x=0;
		for( x=0;x<=10;x++)
			sum+=x;
		System.out.println("sum of 0to"+x);
		System.out.println(sum);
		//4
	/*	try{
		Double d=new Double("120D");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(d);*/
		
//5
		int testdata[]={1,2,3};
		for(int i1:testdata){
			
		}
		//6
		String g="A";
		switch(g){
		case "a":System.out.println("a");
		default: System.out.println("default");
		case "A":System.out.println("A");
		}
		//8
		float m=4;
		float n=2;
		float o = m+n;
		//9
		/*Integer ih=new Integer("12.4");
		System.out.println(ih);*/
		
		List<Integer> l=new ArrayList<Integer>();
		l.add(2);l.add(34);l.add(57);l.add(45);l.add(12);
		l.removeIf(e->e%2!=0);
		System.out.println(l);
		
		//Runn kkk= () -> System.out.println("inferface metgod");
		Runn kkk1= (s) -> System.out.println("inferface metgod"+s);
		
		
		//10
		Integer b=new Integer(10);
		b=b++;
		
		System.out.println(b);
		
		//11
		int i= 234_56_789;
		System.out.println(i);
		Integer.parseInt("we");
		

	}

}
interface Runn{
	String h="";
	void fk(String k);
}
