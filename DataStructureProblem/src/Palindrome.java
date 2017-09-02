
/*public class Palindrome {

	public static void main(String[] args) {
		String g="maddam";
		if(g!=null && g.equals(reverse(g))){
			System.out.println("yes palindrome");
		}

	}

	private static String reverse(String g) {
		if(g!=null && g.length()==1){
			return g;
		}
		return reverse(g.substring(1))+g.charAt(0);
	}

}*/
public class Palindrome {

	public static void main(String[] args) {
		String g="madama";
		System.out.println(checkPalindrome(g));

	}

	private static String checkPalindrome(String g) {
		if(g==null || g.length()==1){
			return g;
		}
		
		int end=g.length()-1;int middle=end/2;
		for(int i=0;i<=middle;i++){
			if(g.charAt(end)==g.charAt(i)){
				end--;
			}
			else{
				break;
			}
		}
		if(end<=middle){
			return "yes";
		}
		return "no";
	}

	
}
