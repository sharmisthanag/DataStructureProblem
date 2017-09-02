package com.java8.test.flowcontrol;

public class FlowControl {

	public static void main(String[] args) {
		//if-lese
		String result="1";
		int score=10;
		if((score=score+10) == 100){
			result="A";
		}
		else if((score=score+29) == 50){
			result="B";
		}
		else if((score=score+200) == 10){
			result="C";
		}
		else{
			result="F";
		}
		System.out.println(result+"="+ score);
		
		//switch
		
		String day=new String("MON");
		//day =null;//compiles but throws null pointer exception
		switch(day){
			case "MON":
			case "TUE":
			case "WED":
			case "THU":
				System.out.println("time to work");
				//break;
				
			case "FRI":
				System.out.println("weekend nearer");
				//break;
			case "SAT":
			case "SUN":
				System.out.println("weekend");
				//break;
			/*case default: invalid*/
			default:
				System.out.println("invalid day");
				//break;			
		}
		System.out.println("_____________________________");
		//2
		String day1=new String("MONN");
		
		switch(day1){
		default:
			System.out.println("invalid day");
			break;
			case "MON":
			case "TUE":
			case "WED":
			case "THU":
				System.out.println("time to work");
				break;
				
			case "FRI":
				System.out.println("weekend nearer");
				break;
			case "SAT":
			case "SUN":
				System.out.println("weekend");
				break;
			/*case default: invalid*/
						
		}
		//3
		final int a=10;
		final int b=20;
		final int c=30;
		
		switch(a){
			
			case a+b://have to be compile time constant value,so making variables as final
			case b+c:
			case c+a:
				System.out.println("time to work");
				break;
				
			case 10+21://shows duplicate case when case is written 10+20,so chnaged to 10+21
				System.out.println("weekend nearer");
				break;
			default:
				System.out.println("invalid day");
				break;
						
		}
		System.out.println("------------------------------------4");
		//4
		final int a1=10;
		final int b1=20;
		final int c1=0;
		//c1=30;//b+2 will not be considered as constant as c was not initialized with its declaration,so making c1=0
		switch(a1){
			
			case a1+b1://have to be compile time constant value,so making variables as final
			case b1+c1:
			case c1+a1:
				System.out.println("time to work");
				break;
				
			case 10+21://shows duplicate case when case is written 10+20,so chnaged to 10+21
				System.out.println("weekend nearer");
				break;
			default:
				System.out.println("invalid day");
				break;
						
		}
		
		long daycount=31;
		/*switch(daycount){//char sort byte int String Integer Short Byte Char allowed inside switch
		
		}*/
		if(daycount == 21 || daycount==90);
		
		
		
	}
	
}
