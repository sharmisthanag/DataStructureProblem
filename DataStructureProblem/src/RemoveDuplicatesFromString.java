
public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		String s="aabbhhttggfdgggkkkaa";
		System.out.println(removeDuplicates(s));

	}

	/*private static String removeDuplicates(String s) {
		String d="";
		for(int i=0;i<s.length();i++){
			if(!d.contains(String.valueOf(s.charAt(i)))){
				d=d+s.charAt(i);				
			}
		}
		return d;
	}*/
	private static String removeDuplicates(String s) {
		String d="";
		for(int i=0;i<s.length();i++){
			if(!d.contains(String.valueOf(s.charAt(i)))){
				d=d+s.charAt(i);
			}
		}
		return d;
	}


}
