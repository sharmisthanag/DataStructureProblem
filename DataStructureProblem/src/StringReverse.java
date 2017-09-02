
public class StringReverse {

	public static void main(String[] args) {
		String s="Hello World";
		 //reversed string using Stringbuffer
		StringBuffer ss=new StringBuffer(s);
		System.out.println(ss.reverse());
		
		//iterative method to reverse String in Java
		String r="";
		for(int i=s.length()-1;i>=0;i--){
			r=r+s.charAt(i);
		}
		System.out.println(r);
		//recursive method to reverse String in Java
		System.out.println(reverseResursively(s));
	}

	
	private static String reverseResursively(String s) {
		if(s!=null && s.length()==1){
			return s;
		}
		return reverseResursively(s.substring(1))+s.charAt(0);
	}
}
